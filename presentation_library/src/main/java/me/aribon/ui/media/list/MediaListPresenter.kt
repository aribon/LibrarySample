package me.aribon.library.ui.media.list

import io.reactivex.android.schedulers.AndroidSchedulers
import me.aribon.library.ui.base.BaseAppPresenter
import me.aribon.library.ui.media.details.MediaDetailsFragment
import me.aribon.library.ui.model.MediaItemViewModel
import me.aribon.library.ui.model.mapper.BookItemViewModelMapper
import me.aribon.ui.media.list.MediaListUseCase

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class MediaListPresenter(
    val view: MediaListContract.View,
    private val mediaListUseCase: MediaListUseCase) :
    BaseAppPresenter(),
    MediaListContract.Presenter {

  init {
    view.setPresenter(this)
  }

  override fun subscribe() {
    super.subscribe()
//    App.instance.getStore()
//        .subscribe(this)

    val categoryId = (view as MediaListFragment)
                         .arguments
                         ?.getString(MediaListFragment.CATEGORY_LIST_CATEGORY_ID) ?: ""

//    App.instance
//        .getStore()
//        .dispatch(BookListAction.Fetch(categoryId))

    getBookList(categoryId)
  }

  override fun unsubscribe() {
    super.unsubscribe()
//    App.instance.getStore()
//        .unsubscribe(this)
  }

  override fun onMediaSelected(mediaItemViewModel: MediaItemViewModel) {
//    App.instance
//        .getStore()
//        .dispatch(BookListAction.Select(mediaItemViewModel.id))
  }

  private fun getBookList(categoryId: String) {
    executeRequest(
        mediaListUseCase.getMediaItemList(categoryId)
            .doOnSubscribe { view.render(emptyArray(), true) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
//                  App.instance
//                      .getStore()
//                      .dispatch(BookListAction.Display(it))

                  view.render(it.toTypedArray(), false)
                },
                {
                  view.showError("Une erreur s'est produite")
                }
                      )
                  )
  }

//  override fun onStateChange(newState: State) {
//    when (newState) {
//      is BookListState -> {
//        when {
//          newState.isFetching -> {
//            view.render(newState.viewModelList.toTypedArray(), true)
//            getBookList(newState.categoryId)
//          }
//          newState.isRender   -> view.render(newState.viewModelList.toTypedArray(), false)
//          newState.isSelected -> App.instance
//              .getStore()
//              .dispatch(Navigate(newState.bookSelectedId))
//          newState.isNavigate -> Router().openFragment(
//              (view as MediaListFragment),
//              MediaDetailsFragment.newInstance(newState.bookSelectedId)
//                                                      )
//        }
//      }
//    }
//  }
}