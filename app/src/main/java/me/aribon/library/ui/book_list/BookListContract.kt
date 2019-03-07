package me.aribon.library.ui.book_list

import me.aribon.library.ui.base.AppPresenter
import me.aribon.library.ui.base.AppView
import me.aribon.library.ui.model.BookItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
interface BookListContract {

  interface View : AppView<Presenter> {
    fun render(bookList: Array<BookItemViewModel>, isLoading: Boolean)
  }

  interface Presenter : AppPresenter {
    fun onBookSelected(bookItemViewModel: BookItemViewModel)
  }
}