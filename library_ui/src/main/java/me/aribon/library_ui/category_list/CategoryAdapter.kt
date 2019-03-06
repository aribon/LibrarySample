package me.aribon.library_ui.category_list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_category.view.*
import me.aribon.library_ui.R
import me.aribon.library_ui.model.CategoryItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class CategoryAdapter(
    private val context: Context,
    private val data: Array<CategoryItemViewModel>,
    private val listener: CategoryAdapterListener) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): CategoryAdapter.CategoryViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false) as TextView
        return CategoryViewHolder(textView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val viewModel = data[position]
        holder.itemView.tvCategoryItemTitle.text = String.format(context.getString(R.string.tui_category_item_label, viewModel.categoryLabel))
        holder.itemView.tvCategoryItemBooksAvailable.text = String.format(context.getString(R.string.tui_category_item_books_available, viewModel.booksAvailable))
        holder.itemView.setOnClickListener {
            listener.onCategoryItemClick(viewModel)
        }
    }

    override fun getItemCount() = data.size

    interface CategoryAdapterListener {
        fun onCategoryItemClick(categoryItemViewModel: CategoryItemViewModel)
    }
}