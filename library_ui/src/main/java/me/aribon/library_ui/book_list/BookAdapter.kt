package me.aribon.library_ui.book_list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.item_book.view.*
import me.aribon.library_ui.R
import me.aribon.library_ui.model.BookItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class BookAdapter(
    private val context: Context,
    private val data: Array<BookItemViewModel>,
    private val listener: BookAdapterListener) :
    RecyclerView.Adapter<BookAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): BookAdapter.CategoryViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false) as TextView
        return CategoryViewHolder(textView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val viewModel = data[position]
        holder.itemView.tvBookItemTitle.text = String.format(context.getString(R.string.tui_book_item_title, viewModel.title))
        holder.itemView.tvBookItemAuthor.text = String.format(context.getString(R.string.tui_book_item_author, viewModel.authors.joinToString(", ")))
        holder.itemView.tvBookItemPublisher.text = String.format(context.getString(R.string.tui_book_item_publisher, viewModel.publisher))
        holder.itemView.tvBookItemPrice.text = String.format(context.getString(R.string.tui_book_item_price, viewModel.price))
        holder.itemView.setOnClickListener {
            listener.onBookItemClick(viewModel)
        }
    }

    override fun getItemCount() = data.size

    interface BookAdapterListener {
        fun onBookItemClick(bookItemViewModel: BookItemViewModel)
    }
}