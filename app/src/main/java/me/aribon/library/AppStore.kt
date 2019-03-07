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
class AppStore(
    state: AppState) {

  private val categoryListReducer = CategoryListReducer()
  private val bookListReducer = BookListReducer()
  private val bookDetailsReducer = BookDetailsReducer()

  private var subscriptions: MutableList<StoreSubscriber> = mutableListOf()

  private var _state: AppState? = state
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

  fun dispatch(action: AppAction) {
    val newState = applyReducers(action)
    this._state = newState
  }

  private fun applyReducers(action: AppAction): AppState {
    var state = state

    when (action) {
      is CategoryListAction -> {
        state = when (state) {
          !is CategoryListState -> categoryListReducer.reduce(CategoryListState(), action)
          else                -> categoryListReducer.reduce(state, action)
        }
      }
      is BookListAction     -> {
        state = when (state) {
          !is BookListState -> bookListReducer.reduce(BookListState(), action)
          else              -> bookListReducer.reduce(state, action)
        }
      }
      is BookDetailsAction  -> {
        state = when (state) {
          !is BookDetailsState -> bookDetailsReducer.reduce(BookDetailsState(), action)
          else                  -> bookDetailsReducer.reduce(state, action)
        }
      }
    }

    return state
  }

  fun subscribe(subscriber: StoreSubscriber) {
    val index = subscriptions.indexOfFirst { it === subscriber }
    if (index == -1) {
      this.subscriptions.add(subscriber)
    }
  }

  fun unsubscribe(subscriber: StoreSubscriber) {
    val index = this.subscriptions.indexOfFirst { it === subscriber }
    if (index != -1) {
      this.subscriptions.removeAt(index)
    }
  }
}