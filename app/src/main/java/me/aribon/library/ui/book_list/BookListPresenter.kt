package me.aribon.library.ui.book_list

import me.aribon.library.App
import me.aribon.library.data.repository.Repository
import me.aribon.library.domain.usecase.GetBookList
import me.aribon.library.redux.action.BookListAction
import me.aribon.library.redux.action.BookListAction.Navigate
import me.aribon.library.redux.base.StoreSubscriber
import me.aribon.library.redux.state.BookListState
import me.aribon.library.route.Router
import me.aribon.library.ui.base.BaseAppPresenter
import me.aribon.library.ui.book_details.BookDetailsFragment
import me.aribon.library.ui.model.BookItemViewModel
import me.aribon.library.ui.model.mapper.BookItemViewModelMapper

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class BookListPresenter(
    val view: BookListContract.View,
    private val getBookList: GetBookList = GetBookList(Repository())) :
    BaseAppPresenter(),
    BookListContract.Presenter,
    StoreSubscriber<BookListState> {

  init {
    view.setPresenter(this)
  }

  override fun subscribe() {
    val categoryId = (view as BookListFragment)
        .arguments
        ?.getString(BookListFragment.CATEGORY_LIST_CATEGORY_ID) ?: ""

    App.instance
        .getStore()
        .dispatch(BookListAction.Fetch(categoryId))
  }

  override fun unsubscribe() {
  }

  override fun onBookSelected(bookItemViewModel: BookItemViewModel) {
    App.instance
        .getStore()
        .dispatch(BookListAction.Select(bookItemViewModel.id))
  }

  private fun getBookList(categoryId: String) {
    executeRequest(
        getBookList.execute(categoryId)
            .map { BookItemViewModelMapper().fromEntity(it) }
            .subscribe(
                {
                  App.instance
                      .getStore()
                      .dispatch(BookListAction.Display(it))
                },
                { view.showError("Une erreur s'est produite") }
                      )
                  )
  }

  override fun onStateChange(newState: BookListState) {
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
          (view as BookListFragment),
          BookDetailsFragment.newInstance(newState.bookSelectedId))
    }
  }
}