package me.aribon.library.redux.state

import me.aribon.library.ui.model.BookItemViewModel

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
data class BookListState(
    val viewModelList: Collection<BookItemViewModel> = emptyList(),
    val categoryId: String = "",
    val bookSelectedId: String = "",
    val isFetching: Boolean = false,
    val isRender: Boolean = false,
    val isSelected: Boolean = false,
    val isNavigate: Boolean = false,
    val error: Throwable? = null)
  : AppState