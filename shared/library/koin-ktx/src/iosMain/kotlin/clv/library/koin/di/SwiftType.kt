package clv.library.koin.di

import kotlin.reflect.KClass
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.ObjCObject
import kotlinx.cinterop.ObjCProtocol
import kotlinx.cinterop.getOriginalKotlinClass

public data class SwiftType(
    val type: ObjCObject,
    val swiftClazz: KClass<*>,
)

public fun SwiftType.getClazz(): KClass<*> = when (type) {
    is ObjCClass -> getOriginalKotlinClass(type)
    is ObjCProtocol -> getOriginalKotlinClass(type)
    else -> null
} ?: swiftClazz
