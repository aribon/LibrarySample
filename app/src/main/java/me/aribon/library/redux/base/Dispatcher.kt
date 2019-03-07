package me.aribon.library.redux.base

import me.aribon.library.redux.base.Action

/**
 * @Author: aribon
 * @Date: 04/03/2019
 */
interface Dispatcher {

  fun dispatch(action: Action)
}