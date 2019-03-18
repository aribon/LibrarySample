package me.aribon.library.data.provider.network.mapper

import me.aribon.data.repository.mapper.RepositoryMapper
import me.aribon.data_glose.provider.network.Response.BookResponse
import me.aribon.domain_library.model.MediaEntity

class BookResponseMapper : RepositoryMapper<MediaEntity, BookResponse>() {
  override fun map(value: BookResponse): MediaEntity {
    return MediaEntity(
        id = value.id,
        title = value.title,
        shortTitle = value.shortTitle,
        authors = value.authors.map { it.name },
        publisher = listOf(value.publisher) as Collection<String>,
        description = value.description,
        price = value.price?.amount?.toDouble() ?: 0.0,
        imageUrl = value.image
                      )
  }
}