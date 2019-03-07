package me.aribon.library.ui.book_details

import me.aribon.library.ui.base.AppPresenter
import me.aribon.library.ui.base.AppView
import me.aribon.library.ui.model.BookDetailsViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
interface BookDetailsContract {

  interface View : AppView<Presenter> {
    fun render(viewModel: BookDetailsViewModel?, isLoading: Boolean)
  }

  interface Presenter : AppPresenter {

  }
}