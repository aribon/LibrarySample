package me.aribon.library.ui.model.mapper

import me.aribon.library.domain.model.BookEntity
import me.aribon.library.ui.model.BookItemViewModel

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class BookItemViewModelMapper : Mapper<BookEntity, BookItemViewModel>() {

  override fun toEntity(value: BookItemViewModel): BookEntity {
    return BookEntity(
        value.id,
        title = value.title,
        authors = value.authors,
        publisher = value.publisher,
        price = value.price,
        imageUrl = value.imageUrl
                     )
  }

  override fun fromEntity(value: BookEntity): BookItemViewModel {
    return BookItemViewModel(
        id = value.id,
        title = value.title,
        publisher = value.publisher,
        authors = value.authors,
        price = value.price,
        imageUrl = value.imageUrl
                            )
  }
}