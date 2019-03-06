package me.aribon.redux

/**
 * @Author: aribon
 * @Date: 04/03/2019
 */
interface Reducer<S: State, in A: Action> {
    fun reduce(oldState: S, action: A): S
}