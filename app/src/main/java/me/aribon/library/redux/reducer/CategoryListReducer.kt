package me.aribon.library.redux.reducer

import me.aribon.library.redux.action.CategoryListAction
import me.aribon.library.redux.state.CategoryListState
import me.aribon.library.redux.base.Reducer

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
            viewModelList = state.viewModelList,
            categorySelectedId = state.categorySelectedId,
            isFetching = true,
            isRender = false,
            isSelected = false,
            isNavigate = false,
            error = null)
      }
      is CategoryListAction.Display  -> {
        state = state.copy(
            viewModelList = state.viewModelList,
            categorySelectedId = state.categorySelectedId,
            isFetching = false,
            isRender = true,
            isSelected = false,
            isNavigate = false,
            error = null)
      }
      is CategoryListAction.Select   -> {
        state = state.copy(
            viewModelList = state.viewModelList,
            categorySelectedId = state.categorySelectedId,
            isFetching = false,
            isRender = false,
            isSelected = true,
            isNavigate = false,
            error = null)
      }
      is CategoryListAction.Navigate -> { //TODO path route
        state = state.copy(
            viewModelList = state.viewModelList,
            categorySelectedId = state.categorySelectedId,
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