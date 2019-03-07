package me.aribon.library.redux.reducer

import me.aribon.library.redux.action.BookListAction
import me.aribon.library.redux.state.BookListState
import me.aribon.library.redux.base.Reducer

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
class BookListReducer()
  : Reducer<BookListState, BookListAction> {

  override fun reduce(oldState: BookListState, action: BookListAction): BookListState {
    var state = oldState
    when (action) {
      is BookListAction.Fetch    -> {
        state = state.copy(
            viewModelList = state.viewModelList,
            categoryId = state.categoryId,
            bookSelectedId = state.categoryId,
            isFetching = true,
            isRender = false,
            isSelected = false,
            isNavigate = false,
            error = null)
      }
      is BookListAction.Display  -> {
        state = state.copy(
            viewModelList = state.viewModelList,
            categoryId = state.categoryId,
            bookSelectedId = state.categoryId,
            isFetching = false,
            isRender = true,
            isSelected = false,
            isNavigate = false,
            error = null)
      }
      is BookListAction.Select   -> {
        state = state.copy(
            viewModelList = state.viewModelList,
            categoryId = state.categoryId,
            bookSelectedId = state.categoryId,
            isFetching = false,
            isRender = false,
            isSelected = true,
            isNavigate = false,
            error = null)
      }
      is BookListAction.Navigate -> { //TODO path route
        state = state.copy(
            viewModelList = state.viewModelList,
            categoryId = state.categoryId,
            bookSelectedId = state.categoryId,
            isFetching = false,
            isRender = false,
            isSelected = false,
            isNavigate = true,
            error = null)
      }
    }
    return state
  }
}