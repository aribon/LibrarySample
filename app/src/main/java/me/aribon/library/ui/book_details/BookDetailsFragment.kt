package me.aribon.library.ui.book_details

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.content_book_details.ivBookDetailsImage
import kotlinx.android.synthetic.main.content_book_details.progressBookDetails
import kotlinx.android.synthetic.main.content_book_details.tvBookDetailsAuthor
import kotlinx.android.synthetic.main.content_book_details.tvBookDetailsCategory
import kotlinx.android.synthetic.main.content_book_details.tvBookDetailsDescription
import kotlinx.android.synthetic.main.content_book_details.tvBookDetailsPrice
import kotlinx.android.synthetic.main.content_book_details.tvBookDetailsPublisher
import kotlinx.android.synthetic.main.content_book_details.tvBookDetailsTitle
import kotlinx.android.synthetic.main.content_book_details.viewBookDetails
import me.aribon.library.R
import me.aribon.library.ui.base.BaseFragment
import me.aribon.library.ui.model.BookDetailsViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class BookDetailsFragment :
    BaseFragment(),
    BookDetailsContract.View {

  companion object {

    const val BOOK_DETAILS_BOOK_ID = "book_details_book_id"

    fun newInstance(bookId: String): BookDetailsFragment {
      val fragment = BookDetailsFragment()
      val bundle = Bundle()
      bundle.putString(BOOK_DETAILS_BOOK_ID, bookId)
      fragment.arguments = bundle
      return fragment
    }
  }

  private lateinit var presenter: BookDetailsContract.Presenter

  override fun getLayoutRessource(): Int {
    return R.layout.content_book_details
  }

  override fun setPresenter(presenter: BookDetailsContract.Presenter) {
    this.presenter = presenter
  }

  override fun initializePresenter() {
    super.initializePresenter()
    BooksDetailsPresenter(this)
  }

  override fun onStart() {
    super.onStart()
    presenter.subscribe()
  }

  override fun onStop() {
    presenter.unsubscribe()
    super.onStop()
  }

  override fun showError(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
        .show()
  }

  override fun render(viewModel: BookDetailsViewModel?, isLoading: Boolean) {
    when {
      isLoading -> {
        viewBookDetails.visibility = View.GONE
        progressBookDetails.visibility = View.VISIBLE
      }
      else      -> {
        progressBookDetails.visibility = View.GONE
        viewBookDetails.visibility = View.VISIBLE
        tvBookDetailsTitle.text = viewModel?.title
        tvBookDetailsAuthor.text = viewModel?.authors?.joinToString()
        tvBookDetailsPublisher.text = viewModel?.publisher
        tvBookDetailsCategory.text = viewModel?.category
        tvBookDetailsDescription.text = viewModel?.description
        tvBookDetailsPrice.text = viewModel?.price.toString()
        Glide.with(this)
            .load(viewModel?.imageUrl)
            .into(ivBookDetailsImage)
      }
    }
  }
}