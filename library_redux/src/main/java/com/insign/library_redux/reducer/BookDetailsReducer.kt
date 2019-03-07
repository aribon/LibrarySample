package com.insign.library_redux.reducer

import com.insign.library_redux.action.BookDetailsAction
import com.insign.library_redux.state.BookDetailsState
import me.aribon.redux.Reducer

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
class BookDetailsReducer()
  : Reducer<BookDetailsState, BookDetailsAction> {
  override fun reduce(oldState: BookDetailsState, action: BookDetailsAction): BookDetailsState {
    var state = oldState
    when (action) {
      is BookDetailsAction.Fetch -> {
        state = state.copy(
            isLoading = true,
            isComplete = false,
            render = false,
            error = null)
      }
      is BookDetailsAction.Display -> {
        state = state.copy(
            isLoading = false,
            isComplete = true,
            render = true,
            error = null)
      }
      is BookDetailsAction.Navigate -> { //TODO path route
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