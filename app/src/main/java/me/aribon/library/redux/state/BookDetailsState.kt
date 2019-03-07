package me.aribon.library.redux.state

import me.aribon.library.ui.model.BookDetailsViewModel

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
data class BookDetailsState(
    val viewModel: BookDetailsViewModel? = null,
    val bookId: String = "",
    val isFetching: Boolean = false,
    val isRender: Boolean = false,
    val error: Throwable? = null)
  : AppState