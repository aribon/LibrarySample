package me.aribon.library.redux.reducer

import me.aribon.library.redux.action.BookDetailsAction
import me.aribon.library.redux.state.BookDetailsState
import me.aribon.library.redux.base.Reducer

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
class BookDetailsReducer
  : Reducer<BookDetailsState, BookDetailsAction> {

  override fun reduce(oldState: BookDetailsState, action: BookDetailsAction): BookDetailsState {
    var state = oldState
    when (action) {
      is BookDetailsAction.Fetch    -> {
        state = state.copy(
            viewModel = state.viewModel,
            bookId = action.bookId,
            isFetching = true,
            isRender = false,
            error = null)
      }
      is BookDetailsAction.Display  -> {
        state = state.copy(
            viewModel = action.viewModel,
            bookId = state.bookId,
            isFetching = false,
            isRender = true,
            error = null)
      }
    }
    return state
  }
}