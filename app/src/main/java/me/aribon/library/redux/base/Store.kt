package me.aribon.library.redux.base

/**
 * @Author: aribon
 * @Date: 04/03/2019
 */
abstract class Store<S : State, in A : Action>(
    state: S,
    private val reducer: Reducer<S, A>) {

  private var subscriptions: MutableList<StoreSubscriber<S>> = mutableListOf()

  private var _state: S? = state
    set(value) {
      val oldValue = field
      field = value

      value?.let {
        subscriptions.forEach {
          it.onStateChange(value)
        }
      }
    }

  private val state: S
    get() {
      return _state!!
    }

  fun dispatch(action: A) {
    val newState = applyReducers(action)
    this._state = newState
  }

  private fun applyReducers(action: A): S {
    var state = state
    state = reducer.reduce(state, action)
    return state
  }

  fun <Subscriber : StoreSubscriber<S>> subscribe(subscriber: Subscriber) {
    val index = this.subscriptions.indexOfFirst { it === subscriber }
    if (index != -1) {
      this.subscriptions.add(subscriber)
    }
  }

  fun <Subscriber : StoreSubscriber<S>> unsubscribe(subscriber: Subscriber) {
    val index = this.subscriptions.indexOfFirst { it === subscriber }
    if (index != -1) {
      this.subscriptions.removeAt(index)
    }
  }
}