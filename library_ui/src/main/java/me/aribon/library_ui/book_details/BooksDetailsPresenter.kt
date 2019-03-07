package me.aribon.library_ui.book_details

import com.insign.library_redux.state.BookDetailsState
import me.aribon.library_domain.usecase.GetBook
import me.aribon.library_ui.base.BaseAppPresenter
import me.aribon.library_ui.model.mapper.BookDetailsViewModelMapper
import me.aribon.redux.StoreSubscriber

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class BooksDetailsPresenter(
    val view: BookDetailsContract.View,
    private val getBook: GetBook = GetBook()) :
    BaseAppPresenter(),
    BookDetailsContract.Presenter,
    StoreSubscriber<BookDetailsState> {

    init {
        view.setPresenter(this)
    }

    override fun subscribe() {
        getBook("")
    }

    override fun unsubscribe() {

    }

    private fun getBook(bookId: String) {
        executeRequest(
            getBook.execute(bookId)
                .map { BookDetailsViewModelMapper().fromEntity(it) }
                .subscribe(
                    {  },
                    { view.showError("Une erreur s'est produite") }
                )
        )
    }

    override fun onStateChange(newState: BookDetailsState) {
        view.render()
    }
}