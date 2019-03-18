package me.aribon.library.ui.media.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_book.view.ivBookItemImage
import kotlinx.android.synthetic.main.item_book.view.tvBookItemAuthor
import kotlinx.android.synthetic.main.item_book.view.tvBookItemPrice
import kotlinx.android.synthetic.main.item_book.view.tvBookItemPublisher
import kotlinx.android.synthetic.main.item_book.view.tvBookItemTitle
import me.aribon.library.R
import me.aribon.library.ui.media.list.MediaAdapter.CategoryViewHolder
import me.aribon.library.ui.model.MediaItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class MediaAdapter(
    private val context: Context,
    private val data: Array<MediaItemViewModel>,
    private val listener: BookAdapterListener) :
    RecyclerView.Adapter<CategoryViewHolder>() {

  class CategoryViewHolder(view: View) : RecyclerView.ViewHolder(view)

  override fun onCreateViewHolder(parent: ViewGroup,
                                  viewType: Int): CategoryViewHolder {
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_book2, parent, false)
    return CategoryViewHolder(view)
  }

  override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
    val viewModel = data[position]
    holder.itemView.tvBookItemTitle.text =
        String.format(context.getString(R.string.tui_book_item_title, viewModel.title))

    when {
      viewModel.authors.isNullOrEmpty() -> {
        holder.itemView.tvBookItemAuthor.visibility = View.GONE
      }
      else -> {
        holder.itemView.tvBookItemAuthor.visibility = View.VISIBLE
        holder.itemView.tvBookItemAuthor.text =
            String.format(
                context.getString(
                    R.string.tui_book_item_author,
                    viewModel.authors.joinToString(", ")))
      }
    }

    when {
      viewModel.publisher.isNullOrEmpty() -> {
        holder.itemView.tvBookItemPublisher.visibility = View.GONE
      }
      else -> {
        holder.itemView.tvBookItemPublisher.visibility = View.VISIBLE
        holder.itemView.tvBookItemPublisher.text =
            String.format(
                context.getString(
                    R.string.tui_book_item_publisher,
                    viewModel.publisher.joinToString(", ")))
      }
    }

    when {
      viewModel.price == 0.00 -> {
        holder.itemView.tvBookItemPrice.visibility = View.GONE
      }
      else -> {
        holder.itemView.tvBookItemPrice.visibility = View.VISIBLE
        holder.itemView.tvBookItemPrice.text =
            String.format(
                context.getString(
                    R.string.tui_book_item_price,
                    viewModel.price))
      }
    }

    Glide.with(context)
        .load(viewModel.imageUrl)
        .into(holder.itemView.ivBookItemImage)

    holder.itemView.setOnClickListener {
      listener.onBookItemClick(viewModel)
    }
  }

  override fun getItemCount() = data.size

  interface BookAdapterListener {
    fun onBookItemClick(bookItemViewModel: MediaItemViewModel)
  }
}