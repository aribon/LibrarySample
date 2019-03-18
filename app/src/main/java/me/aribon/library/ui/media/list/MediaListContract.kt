package me.aribon.library.ui.media.list

import me.aribon.library.ui.base.AppPresenter
import me.aribon.library.ui.base.AppView
import me.aribon.library.ui.model.MediaItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
interface MediaListContract {

  interface View : AppView<Presenter> {
    fun render(mediaList: Array<MediaItemViewModel>, isLoading: Boolean)
  }

  interface Presenter : AppPresenter {
    fun onMediaSelected(mediaItemViewModel: MediaItemViewModel)
  }
}