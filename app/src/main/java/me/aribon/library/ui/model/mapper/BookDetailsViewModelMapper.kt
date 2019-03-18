package me.aribon.library.ui.model.mapper

import me.aribon.domain_library.model.MediaEntity
import me.aribon.presentation.mapper.ViewModelMapper
import me.aribon.library.ui.model.MediaDetailsViewModel

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */

class BookDetailsViewModelMapper : ViewModelMapper<MediaEntity, MediaDetailsViewModel>() {

  override fun toEntity(value: MediaDetailsViewModel): MediaEntity {
    return MediaEntity(
        value.id,
        title = value.title,
        authors = value.authors,
        publisher = value.publisher,
        description = value.description,
        price = value.price,
        imageUrl = value.imageUrl
                      )
  }

  override fun fromEntity(value: MediaEntity): MediaDetailsViewModel {
    return MediaDetailsViewModel(
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