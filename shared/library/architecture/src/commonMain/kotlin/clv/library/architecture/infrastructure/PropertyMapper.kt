package clv.library.architecture.infrastructure

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

public fun <D, E> ReadWriteProperty<Any?, E>.map(mapper: Mapper<D, E>): ReadWriteProperty<Any?, D> {
    val delegate = this
    return object : ReadWriteProperty<Any?, D> {
        override fun getValue(thisRef: Any?, property: KProperty<*>): D {
            return mapper.toDomain(delegate.getValue(thisRef, property))
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: D) {
            delegate.setValue(thisRef, property, mapper.toExternal(value))
        }
    }
}

public interface Mapper<D, E> {
    public fun toDomain(external: E): D
    public fun toExternal(domain: D): E
}

public abstract class FiniteValuesMapper<D, E> : Mapper<D, E> {

    private val externalMapping: Map<E, D> by lazy { allValues().associateBy { toExternal(it) } }

    public abstract fun allValues(): Array<D>

    final override fun toDomain(external: E): D {
        return externalMapping[external] ?: error("Unknown value $external")
    }
}

public inline fun <reified D : Enum<D>, E> enumMapper(
    crossinline mapToExternal: (D) -> E
): Mapper<D, E> = object : FiniteValuesMapper<D, E>() {
    override fun allValues(): Array<D> = enumValues()
    override fun toExternal(domain: D): E = mapToExternal(domain)
}
