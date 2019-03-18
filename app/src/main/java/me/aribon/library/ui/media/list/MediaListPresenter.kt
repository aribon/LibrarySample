package me.aribon.library.ui.media.list

import io.reactivex.android.schedulers.AndroidSchedulers
import me.aribon.domain_library.usecase.GetBookList
import me.aribon.library.App
import me.aribon.library.data.repository.AppRepository
import me.aribon.library.redux.action.BookListAction
import me.aribon.library.redux.action.BookListAction.Navigate
import me.aribon.library.redux.state.BookListState
import me.aribon.library.route.Router
import me.aribon.library.ui.base.BaseAppPresenter
import me.aribon.library.ui.media.details.MediaDetailsFragment
import me.aribon.library.ui.model.MediaItemViewModel
import me.aribon.library.ui.model.mapper.BookItemViewModelMapper
import me.aribon.redux.core.State
import me.aribon.redux.core.StoreSubscriber

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class MediaListPresenter(
    val view: MediaListContract.View,
    private val getBookList: GetBookList = GetBookList(AppRepository())) :
    BaseAppPresenter(),
    MediaListContract.Presenter,
    StoreSubscriber {

  init {
    view.setPresenter(this)
  }

  override fun subscribe() {
    super.subscribe()
    App.instance.getStore()
        .subscribe(this)

    val categoryId = (view as MediaListFragment)
                         .arguments
                         ?.getString(MediaListFragment.CATEGORY_LIST_CATEGORY_ID) ?: ""

    App.instance
        .getStore()
        .dispatch(BookListAction.Fetch(categoryId))
  }

  override fun unsubscribe() {
    super.unsubscribe()
    App.instance.getStore()
        .unsubscribe(this)
  }

  override fun onMediaSelected(mediaItemViewModel: MediaItemViewModel) {
    App.instance
        .getStore()
        .dispatch(BookListAction.Select(mediaItemViewModel.id))
  }

  private fun getBookList(categoryId: String) {
    executeRequest(
        getBookList.execute(categoryId)
            .observeOn(AndroidSchedulers.mainThread())
            .map { BookItemViewModelMapper().fromEntity(it) }
            .subscribe(
                {
                  App.instance
                      .getStore()
                      .dispatch(BookListAction.Display(it))
                },
                {
                  view.showError("Une erreur s'est produite")
                }
                      )
                  )
  }

  override fun onStateChange(newState: State) {
    when (newState) {
      is BookListState -> {
        when {
          newState.isFetching -> {
            view.render(newState.viewModelList.toTypedArray(), true)
            getBookList(newState.categoryId)
          }
          newState.isRender   -> view.render(newState.viewModelList.toTypedArray(), false)
          newState.isSelected -> App.instance
              .getStore()
              .dispatch(Navigate(newState.bookSelectedId))
          newState.isNavigate -> Router().openFragment(
              (view as MediaListFragment),
              MediaDetailsFragment.newInstance(newState.bookSelectedId)
                                                      )
        }
      }
    }
  }
}