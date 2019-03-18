package me.aribon.library.data.provider.network

import io.reactivex.Single
import me.aribon.data.provider.network.RetrofitHelper
import me.aribon.data_glose.provider.network.Response.BookResponse
import me.aribon.data_glose.provider.network.Response.CategoryResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
interface Api {

  class Factory {
    fun create(apiUrl: String, timeOut: Long): Api {
      val retrofit = RetrofitHelper
          .buildRetrofit(
              apiUrl = apiUrl,
              timeOut = timeOut)
      return retrofit.create(Api::class.java)
    }
  }

  @GET("users/5a8411b53ed02c04187ff02a/shelves")
  fun getCategoryList()
      : Single<Collection<CategoryResponse>>

  @GET("shelves/{shelfId}/forms")
  fun getBookList(
      @Path("shelfId")
      id: String)
      : Single<Collection<String>>

  @GET("forms/{formId}")
  fun getBook(
      @Path("formId")
      id: String)
      : Single<BookResponse>
}