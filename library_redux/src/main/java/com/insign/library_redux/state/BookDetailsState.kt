package com.insign.library_redux.state

import me.aribon.redux.State

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
data class BookDetailsState(
    val isLoading: Boolean,
    val isComplete: Boolean,
    val render: Boolean,
    val routePath: String,
    val error: Throwable?)
  : State