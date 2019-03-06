package me.aribon.library_ui.book_list

import me.aribon.library_ui.base.AppPresenter
import me.aribon.library_ui.base.AppView
import me.aribon.library_ui.model.BookItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
interface BookListContract {

    interface View: AppView<Presenter> {
        fun renderList(bookList: Array<BookItemViewModel>)
    }

    interface Presenter: AppPresenter {
        fun onBookSelected(bookItemViewModel: BookItemViewModel)
    }
}