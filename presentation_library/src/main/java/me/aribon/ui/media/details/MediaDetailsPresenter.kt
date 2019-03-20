package me.aribon.library.ui.media.details

import io.reactivex.android.schedulers.AndroidSchedulers
import me.aribon.library.ui.base.BaseAppPresenter
import me.aribon.library.ui.model.mapper.BookDetailsViewModelMapper
import me.aribon.ui.media.details.MediaDetailsUseCase

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class MediaDetailsPresenter(
    val view: MediaDetailsContract.View,
    private val mediaDetailsUseCase: MediaDetailsUseCase) :
    BaseAppPresenter(),
    MediaDetailsContract.Presenter {

  init {
    view.setPresenter(this)
  }

  override fun subscribe() {
    super.subscribe()
    //    App.instance.getStore()
    //        .subscribe(this)

    val bookId =
        (view as MediaDetailsFragment)
            .arguments
            ?.getString(MediaDetailsFragment.BOOK_DETAILS_BOOK_ID) ?: ""

    //    App.instance
    //        .getStore()
    //        .dispatch(BookDetailsAction.Fetch(bookId))

    getBook(bookId)
  }

  override fun unsubscribe() {
    super.unsubscribe()
    //    App.instance.getStore()
    //        .unsubscribe(this)
  }

  private fun getBook(bookId: String) {
    executeRequest(
        mediaDetailsUseCase.getMediaDetails(bookId)
            .doOnSubscribe { view.render(null, true)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                  //                  App.instance
                  //                      .getStore()
                  //                      .dispatch(BookDetailsAction.Display(it))

                  view.render(it, false)
                },
                {
                  view.showError("Une erreur s'est produite")
                }
                      )
                  )
  }

  //  override fun onStateChange(newState: State) {
  //    when (newState) {
  //      is BookDetailsState -> {
  //        when {
  //          newState.isFetching -> {
  //            view.render(newState.viewModel, true)
  //            getBook(newState.bookId)
  //          }
  //          newState.isRender   -> view.render(newState.viewModel, false)
  //        }
  //      }
  //    }
  //  }
}