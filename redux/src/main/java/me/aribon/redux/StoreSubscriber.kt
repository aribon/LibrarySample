package me.aribon.redux

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
interface StoreSubscriber<S: State> {
  fun onStateChange(newState: S)
}