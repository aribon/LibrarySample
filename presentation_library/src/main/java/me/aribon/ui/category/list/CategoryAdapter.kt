package me.aribon.library.ui.category.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_category.view.tvCategoryItemBooksAvailable
import kotlinx.android.synthetic.main.item_category.view.tvCategoryItemTitle
import me.aribon.library.ui.category.list.CategoryAdapter.CategoryViewHolder
import me.aribon.library.ui.model.CategoryItemViewModel
import me.aribon.ui_library.R

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class CategoryAdapter(
    private val context: Context,
    private val data: Array<CategoryItemViewModel>,
    private val listener: CategoryAdapterListener) :
    RecyclerView.Adapter<CategoryViewHolder>() {

  class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view)

  override fun onCreateViewHolder(parent: ViewGroup,
                                  viewType: Int): CategoryViewHolder {
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_category, parent, false)
    return CategoryViewHolder(view)
  }

  override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
    val viewModel = data[position]
    holder.itemView.tvCategoryItemTitle.text =
        String.format(context.getString(R.string.tui_category_item_label, viewModel.categoryLabel))
    holder.itemView.tvCategoryItemBooksAvailable.text = String.format(
        context.getString(R.string.tui_category_item_books_available, viewModel.mediasAvailable))
    holder.itemView.setOnClickListener {
      listener.onCategoryItemClick(viewModel)
    }
  }

  override fun getItemCount() = data.size

  interface CategoryAdapterListener {
    fun onCategoryItemClick(categoryItemViewModel: CategoryItemViewModel)
  }
}