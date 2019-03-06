package me.aribon.library_ui.book_list

import me.aribon.library_domain.usecase.GetBookList
import me.aribon.library_ui.base.BaseAppPresenter
import me.aribon.library_ui.model.BookItemViewModel
import me.aribon.library_ui.model.mapper.BookItemViewModelMapper

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class BookListPresenter(
    val view: BookListContract.View,
    private val getBookList: GetBookList) :
    BaseAppPresenter(),
    BookListContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun subscribe() {
        getBookList("")
    }

    override fun unsubscribe() {

    }

    override fun onBookSelected(bookItemViewModel: BookItemViewModel) {
        //TODO change state
    }

    private fun getBookList(categoryId: String) {
        executeRequest(
            getBookList.execute(categoryId)
                .map { BookItemViewModelMapper().fromEntity(it) }
                .subscribe(
                    { view.renderList(it.toTypedArray()) },
                    { view.showError("Une erreur s'est produite") }
                )
        )
    }
}