package me.aribon.library.ui.model.mapper

import me.aribon.library.domain.model.BookEntity
import me.aribon.library.ui.model.BookDetailsViewModel

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class BookDetailsViewModelMapper : Mapper<BookEntity, BookDetailsViewModel>() {

  override fun toEntity(value: BookDetailsViewModel): BookEntity {
    return BookEntity(
        value.id,
        title = value.title,
        authors = value.authors,
        publisher = value.publisher,
        description = value.description,
        price = value.price,
        imageUrl = value.imageUrl
                     )
  }

  override fun fromEntity(value: BookEntity): BookDetailsViewModel {
    return BookDetailsViewModel(
        id = value.id,
        title = value.title,
        category = "",
        publisher = value.publisher,
        authors = value.authors,
        description = value.description,
        price = value.price,
        imageUrl = value.imageUrl
                               )
  }
}