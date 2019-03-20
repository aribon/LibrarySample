package me.aribon.ui.base

import io.reactivex.Single

/**
 * Created by anthony.ribon
 * On 20/03/2019
 */
interface ViewModelUseCase<T> {
  fun execute(): Single<T>
}