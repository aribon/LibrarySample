package me.aribon.redux

/**
 * @Author: aribon
 * @Date: 04/03/2019
 */
abstract class Store<S: State, in A: Action>(
    val initialState: S,
    val reducer: Reducer<S, A>) {

    protected var currentState: S = initialState

    init {

    }

    fun getState(): S {
        return currentState
    }

    abstract fun dispatch(action: A)
}