package me.aribon.data_glose.repository

import io.reactivex.Flowable
import io.reactivex.Single
import me.aribon.data_glose.provider.network.Service
import me.aribon.data.repository.mapper.RepositoryMapper
import me.aribon.data_glose.provider.network.Response.BookResponse
import me.aribon.data_glose.provider.network.Response.CategoryResponse

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
open class GloseRepository {

  protected fun <ENTITY: Any, MAPPER: RepositoryMapper<ENTITY, CategoryResponse>> getCategoryList(mapper: MAPPER): Single<Collection<ENTITY>> {
    return Service()
        .getCategoryList()
        .map {
          mapper.map(it)
        }
  }

  protected fun <ENTITY: Any, MAPPER: RepositoryMapper<ENTITY, BookResponse>> getBookList(id: String, mapper: MAPPER): Single<Collection<ENTITY>> {
    return Service()
        .getBookList(id)
        .flatMap { bookIdList ->
          Flowable.fromIterable(bookIdList)
              .flatMapSingle { bookId ->
                Service().getBook(bookId)
              }
              .toList()
        }
        .map { bookList ->
          mapper.map(bookList)
        }
  }

  protected fun <ENTITY: Any, MAPPER: RepositoryMapper<ENTITY, BookResponse>> getBook(id: String, mapper: MAPPER): Single<ENTITY> {
    return Service()
        .getBook(id)
        .map {
          mapper.map(it)
        }
  }
}
