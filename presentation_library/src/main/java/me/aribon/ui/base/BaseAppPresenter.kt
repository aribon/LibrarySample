package me.aribon.library.ui.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
open class BaseAppPresenter {

//  private var compositeDisposable = CompositeDisposable()

  open fun subscribe() {
//    if (compositeDisposable.isDisposed)
//      compositeDisposable = CompositeDisposable()
  }

  open fun unsubscribe() {
//    compositeDisposable.dispose()
  }

  fun executeRequest(disposable: Disposable) {
//    compositeDisposable.add(disposable)
  }
}