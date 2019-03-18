package me.aribon.library.ui.media.details

import io.reactivex.android.schedulers.AndroidSchedulers
import me.aribon.domain_library.usecase.GetBook
import me.aribon.library.App
import me.aribon.library.data.repository.AppRepository
import me.aribon.library.redux.action.BookDetailsAction
import me.aribon.library.redux.state.BookDetailsState
import me.aribon.library.ui.base.BaseAppPresenter
import me.aribon.library.ui.model.mapper.BookDetailsViewModelMapper
import me.aribon.redux.core.State
import me.aribon.redux.core.StoreSubscriber

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class MediaDetailsPresenter(
    val view: MediaDetailsContract.View,
    private val getBook: GetBook = GetBook(AppRepository())) :
    BaseAppPresenter(),
    MediaDetailsContract.Presenter,
    StoreSubscriber {

  init {
    view.setPresenter(this)
  }

  override fun subscribe() {
    super.subscribe()
    App.instance.getStore()
        .subscribe(this)

    val bookId =
        (view as MediaDetailsFragment)
            .arguments
            ?.getString(MediaDetailsFragment.BOOK_DETAILS_BOOK_ID) ?: ""

    App.instance
        .getStore()
        .dispatch(BookDetailsAction.Fetch(bookId))
  }

  override fun unsubscribe() {
    super.unsubscribe()
    App.instance.getStore()
        .unsubscribe(this)
  }

  private fun getBook(bookId: String) {
    executeRequest(
        getBook.execute(bookId)
            .observeOn(AndroidSchedulers.mainThread())
            .map { BookDetailsViewModelMapper().fromEntity(it) }
            .subscribe(
                {
                  App.instance
                      .getStore()
                      .dispatch(BookDetailsAction.Display(it))
                },
                {
                  view.showError("Une erreur s'est produite")
                }
                      )
                  )
  }

  override fun onStateChange(newState: State) {
    when (newState) {
      is BookDetailsState -> {
        when {
          newState.isFetching -> {
            view.render(newState.viewModel, true)
            getBook(newState.bookId)
          }
          newState.isRender   -> view.render(newState.viewModel, false)
        }
      }
    }
  }
}