package me.aribon.library.redux.base

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
interface StoreSubscriber {
  fun onStateChange(newState: State)
}