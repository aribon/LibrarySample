package me.aribon.library

import me.aribon.redux.Store

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class AppStore(initialState: AppState, reducer: AppReducer)
    : Store<AppState, AppAction>(initialState, reducer) {

    override fun dispatch(action: AppAction) {
        val newState = applyReducers(action)
        currentState = newState
    }

    private fun applyReducers(action: AppAction): AppState {
        var state = currentState

        state = reducer.reduce(state, action)

        return state
    }

}