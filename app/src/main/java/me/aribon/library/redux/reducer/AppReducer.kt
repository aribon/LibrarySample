package me.aribon.library.redux.reducer

import me.aribon.library.redux.action.AppAction
import me.aribon.library.redux.state.AppState
import me.aribon.redux.core.Reducer

/**
 * Created by anthony.ribon
 * On 14/03/2019
 */
interface AppReducer<S: AppState, in A: AppAction>: Reducer<S, A>