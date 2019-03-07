package me.aribon.library.redux.state

import me.aribon.library.ui.model.CategoryItemViewModel

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
data class CategoryListState(
    val viewModelList: Collection<CategoryItemViewModel> = emptyList(),
    val categorySelectedId: String = "",
    val isFetching: Boolean = false,
    val isRender: Boolean = false,
    val isSelected: Boolean = false,
    val isNavigate: Boolean = false,
    val error: Throwable? = null)
  : AppState