package me.aribon.library_ui.book_details

import me.aribon.library_domain.usecase.GetBook
import me.aribon.library_ui.base.BaseAppPresenter
import me.aribon.library_ui.model.BookDetailsViewModel
import me.aribon.library_ui.model.mapper.BookDetailsViewModelMapper

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class BooksDetailsPresenter(
    val view: BookDetailsContract.View,
    private val getBook: GetBook) :
    BaseAppPresenter(),
    BookDetailsContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun subscribe() {
        getBook("")
    }

    override fun unsubscribe() {

    }

    private fun setFields(booksDetailsViewModel: BookDetailsViewModel) {
        view.renderTitle(booksDetailsViewModel.title)
        view.renderAuthor(booksDetailsViewModel.authors.joinToString())
        view.renderPublisher(booksDetailsViewModel.publisher)
        view.renderCategory(booksDetailsViewModel.category)
        view.renderDescription(booksDetailsViewModel.description)
        view.renderPrice(booksDetailsViewModel.price)
    }

    private fun getBook(bookId: String) {
        executeRequest(
            getBook.execute(bookId)
                .map { BookDetailsViewModelMapper().fromEntity(it) }
                .subscribe(
                    { setFields(it) },
                    { view.showError("Une erreur s'est produite") }
                )
        )
    }
}