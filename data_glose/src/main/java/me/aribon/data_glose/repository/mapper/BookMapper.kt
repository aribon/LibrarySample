package me.aribon.data_glose.repository.mapper

import me.aribon.data_glose.provider.network.Response
import me.aribon.library_domain.model.BookEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class BookMapper : Mapper<BookEntity, Response.BookResponse>() {

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