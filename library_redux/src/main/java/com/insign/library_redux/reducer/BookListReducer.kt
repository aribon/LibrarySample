package com.insign.library_redux.reducer

import com.insign.library_redux.action.BookListAction
import com.insign.library_redux.state.BookListState
import me.aribon.redux.Reducer

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
            isLoading = true,
            isComplete = false,
            render = false,
            bookSelectedId = "",
            error = null)
      }
      is BookListAction.Display  -> {
        state = state.copy(
            isLoading = false,
            isComplete = true,
            render = true,
            error = null)
      }
      is BookListAction.Select  -> {
        state = state.copy(
            isLoading = false,
            isComplete = true,
            render = true,
            bookSelectedId = action.bookId,
            error = null)
      }
      is BookListAction.Navigate -> { //TODO path route
        state = state.copy(
            isLoading = false,
            isComplete = true,
            render = true,
            error = null)
      }
    }
    return state
  }
}