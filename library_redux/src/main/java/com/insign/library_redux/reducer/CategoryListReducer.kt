package com.insign.library_redux.reducer

import com.insign.library_redux.action.CategoryListAction
import com.insign.library_redux.state.CategoryListState
import me.aribon.redux.Reducer

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
class CategoryListReducer()
  : Reducer<CategoryListState, CategoryListAction> {
  override fun reduce(oldState: CategoryListState, action: CategoryListAction): CategoryListState {
    var state = oldState
    when (action) {
      is CategoryListAction.Fetch    -> {
        state = state.copy(
            isLoading = true,
            isComplete = false,
            render = false,
            categorySelectedId = "",
            error = null)
      }
      is CategoryListAction.Display  -> {
        state = state.copy(
            isLoading = false,
            isComplete = true,
            render = true,
            error = null)
      }
      is CategoryListAction.Select   -> {
        state = state.copy(
            isLoading = false,
            isComplete = true,
            render = true,
            categorySelectedId = action.categoryId,
            error = null)
      }
      is CategoryListAction.Navigate -> { //TODO path route
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