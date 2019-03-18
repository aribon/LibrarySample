package me.aribon.library.ui.media.details

import me.aribon.library.ui.base.AppPresenter
import me.aribon.library.ui.base.AppView
import me.aribon.library.ui.model.MediaDetailsViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
interface MediaDetailsContract {

  interface View : AppView<Presenter> {
    fun render(viewModel: MediaDetailsViewModel?, isLoading: Boolean)
  }

  interface Presenter : AppPresenter
}