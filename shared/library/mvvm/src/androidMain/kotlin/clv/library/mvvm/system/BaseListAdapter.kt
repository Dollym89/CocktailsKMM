package clv.library.mvvm.system

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

public abstract class BaseListAdapter<I, B : ViewBinding>(
    diffCallback: DiffUtil.ItemCallback<I>,
) : ListAdapter<I, BaseListAdapter<I, B>.ViewHolder>(diffCallback) {

    protected abstract fun onCreateViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean,
    ): B

    protected open fun B.onBindItems(item: I) {}

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(onCreateViewBinding(LayoutInflater.from(parent.context), parent, false))
    }

    final override fun onBindViewHolder(holder: ViewHolder, position: Int) {}

    @Suppress("UNCHECKED_CAST")
    final override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int,
        payloads: MutableList<Any>,
    ) {
        (payloads.firstOrNull() as? I)
            ?.let { holder.binding.onBindItems(it) }
            ?: holder.binding.onBindItems(getItem(position))
    }

    public inner class ViewHolder(public val binding: B) : RecyclerView.ViewHolder(binding.root)
}
