package me.aribon.library

import me.aribon.library.redux.action.AppAction
import me.aribon.library.redux.action.BookDetailsAction
import me.aribon.library.redux.action.BookListAction
import me.aribon.library.redux.action.CategoryListAction
import me.aribon.library.redux.base.StoreSubscriber
import me.aribon.library.redux.reducer.BookDetailsReducer
import me.aribon.library.redux.reducer.BookListReducer
import me.aribon.library.redux.reducer.CategoryListReducer
import me.aribon.library.redux.state.AppState
import me.aribon.library.redux.state.BookDetailsState
import me.aribon.library.redux.state.BookListState
import me.aribon.library.redux.state.CategoryListState

/**
 * @Author: aribon
 * @Date: 04/03/2019
 */
abstract class AppStore {

    private val categoryListReducer = CategoryListReducer()
    private val bookListReducer = BookListReducer()
    private val bookDetailsReducer = BookDetailsReducer()

    private var subscriptions: MutableList<StoreSubscriber<AppState>> = mutableListOf()

    private var _state: AppState? = null
        set(value) {
            val oldValue = field
            field = value

            value?.let {
                subscriptions.forEach {
                    it.onStateChange(value)
                }
            }
        }

    private val state: AppState
        get() {
            return _state!!
        }

    fun <A: AppAction> dispatch(action: A) {
        val newState = applyReducers(action)
        this._state = newState
    }

    private fun <A: AppAction> applyReducers(action: A): AppState {
        var state = state

        when (action) {
            is CategoryListAction -> {
                state = categoryListReducer.reduce(state as CategoryListState, action)
            }
            is BookListAction -> {
                state = bookListReducer.reduce(state as BookListState, action)
            }
            is BookDetailsAction -> {
                state = bookDetailsReducer.reduce(state as BookDetailsState, action)
            }
        }

        return state
    }

    fun <State: AppState, Subscriber : StoreSubscriber<State>> subscribe(subscriber: Subscriber) {
        val index = this.subscriptions.indexOfFirst { it === subscriber }
        if (index != -1) {
//            this.subscriptions.add(subscriber)
        }
    }

    fun <State: AppState, Subscriber : StoreSubscriber<State>> unsubscribe(subscriber: Subscriber) {
        val index = this.subscriptions.indexOfFirst { it === subscriber }
        if (index != -1) {
            this.subscriptions.removeAt(index)
        }
    }
}