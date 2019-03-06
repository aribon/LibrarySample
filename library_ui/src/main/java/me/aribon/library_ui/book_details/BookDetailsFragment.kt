package me.aribon.library_ui.book_details

import android.widget.Toast
import kotlinx.android.synthetic.main.content_book_details.*
import me.aribon.core_ui.BaseFragment
import me.aribon.library_ui.R

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

    override fun renderTitle(title: String) {
        tvBookDetailsTitle.text = title
    }

    override fun renderAuthor(author: String) {
        tvBookDetailsAuthor.text = author
    }

    override fun renderPublisher(publisher: String) {
        tvBookDetailsPublisher.text = publisher
    }

    override fun renderCategory(category: String) {
        tvBookDetailsCategory.text = category
    }

    override fun renderDescription(description: String) {
        tvBookDetailsDescription.text = description
    }

    override fun renderPrice(price: Double) {
        tvBookDetailsPrice.text = price.toString()
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}