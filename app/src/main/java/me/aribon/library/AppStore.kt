package me.aribon.library

import me.aribon.library.redux.base.Store

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class AppStore(initialState: AppState, reducer: AppReducer)
  : Store<AppState, AppAction>(initialState, reducer)