package me.aribon.library_ui.book_details

import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.content_book_details.*
import me.aribon.core_ui.BaseFragment
import me.aribon.library_ui.R
import me.aribon.library_ui.model.BookDetailsViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class BookDetailsFragment:
    BaseFragment(),
    BookDetailsContract.View {

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

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun render(viewModel: BookDetailsViewModel, isLoading: Boolean) {
        when {
            isLoading -> {
                viewBookDetails.visibility = View.GONE
                progressBookDetails.visibility = View.VISIBLE
            }
            else -> {
                progressBookDetails.visibility = View.GONE
                viewBookDetails.visibility = View.VISIBLE
                tvBookDetailsTitle.text = viewModel.title
                tvBookDetailsAuthor.text = viewModel.authors.joinToString()
                tvBookDetailsPublisher.text = viewModel.publisher
                tvBookDetailsCategory.text = viewModel.category
                tvBookDetailsDescription.text = viewModel.description
                tvBookDetailsPrice.text = viewModel.price.toString()
            }
        }
    }
}