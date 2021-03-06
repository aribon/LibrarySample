package me.aribon.library.ui.base

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
interface AppView<P : AppPresenter> {

  fun setPresenter(presenter: P)
  fun showError(message: String)
}