package me.aribon.data_glose.provider.network

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import me.aribon.library.data.provider.network.Api
import me.aribon.library.data.provider.network.Api.Factory

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class Service {

  private fun getApi(
      apiUrl: String,
      timeOut: Long = 0L): Api {
    return Factory()
        .create(apiUrl, timeOut)
  }

  private fun getBaseUrl(): String {
    return "https://api.glose.com"
  }

  fun getCategoryList(): Single<Collection<Response.CategoryResponse>> {
    return getApi(getBaseUrl())
        .getCategoryList()
        .subscribeOn(Schedulers.io())
  }

  fun getBookList(id: String): Single<Collection<String>> {
    return getApi(getBaseUrl())
        .getBookList(id)
        .onErrorResumeNext {
          error("WS")
        }
        .subscribeOn(Schedulers.io())
  }

  fun getBook(id: String): Single<Response.BookResponse> {
    return getApi(getBaseUrl())
        .getBook(id)
        .subscribeOn(Schedulers.io())
  }
}