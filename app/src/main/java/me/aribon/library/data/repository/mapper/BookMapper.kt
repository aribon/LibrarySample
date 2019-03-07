package me.aribon.library.data.repository.mapper

import me.aribon.library.data.provider.network.Response
import me.aribon.library.data.provider.network.Response.BookResponse
import me.aribon.library.domain.model.BookEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class BookMapper : Mapper<BookEntity, BookResponse>() {

  override fun map(value: Response.BookResponse): BookEntity {
    return BookEntity(
        value.id,
        value.title,
        value.shortTitle,
        value.authors.map { it.name },
        value.publisher,
        value.description,
        value.price.amount.toDouble(),
        value.image
                     )
  }
}