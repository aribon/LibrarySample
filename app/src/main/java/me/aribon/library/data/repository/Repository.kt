package me.aribon.library.data.repository

import io.reactivex.Single
import me.aribon.library.data.provider.network.Service
import me.aribon.library.data.provider.network.mapper.BookMapper
import me.aribon.library.data.provider.network.mapper.CategoryMapper
import me.aribon.library.domain.`interface`.LibraryRepository
import me.aribon.library.domain.model.BookEntity
import me.aribon.library.domain.model.CategoryEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class Repository : LibraryRepository {

  override fun getCategoryList(): Single<Collection<CategoryEntity>> {
    return Service()
        .getCategoryList()
        .map { CategoryMapper().map(it) }
  }

  override fun getBookList(id: String): Single<Collection<String>> {
    return Service()
        .getBookList(id)
  }

  override fun getBook(id: String): Single<BookEntity> {
    return Service()
        .getBook(id)
        .map {
          BookMapper().map(it)
        }
  }
}