package clv.library.mvvm.system

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

public abstract class BaseAdapter<I, B : ViewBinding> :
    RecyclerView.Adapter<BaseAdapter<I, B>.ViewHolder>() {

    private var items: List<I> = emptyList()

    protected abstract fun onCreateViewBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        attachToParent: Boolean,
    ): B

    protected open fun B.onBindItems(item: I) {}

    public fun submitList(list: List<I>) {
        items = list
        notifyDataSetChanged()
    }

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(onCreateViewBinding(LayoutInflater.from(parent.context), parent, false))
    }

    final override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.onBindItems(items[position])
    }

    final override fun getItemCount(): Int = items.size

    public inner class ViewHolder(public val binding: B) : RecyclerView.ViewHolder(binding.root)
}
