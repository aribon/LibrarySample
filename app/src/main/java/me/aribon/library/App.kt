package me.aribon.library

import android.app.Application
import me.aribon.library.redux.state.LaunchState

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class App : Application() {

  companion object {
    lateinit var instance: App
      private set
  }

  private lateinit var store: AppStore

  init {
    instance = this
  }

  override fun onCreate() {
    super.onCreate()
    store = AppStore(LaunchState())
  }

  fun getStore(): AppStore {
    return store
  }
}