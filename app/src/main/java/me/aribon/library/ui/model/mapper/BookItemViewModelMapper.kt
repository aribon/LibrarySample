package me.aribon.library.ui.model.mapper

import me.aribon.domain_library.model.MediaEntity
import me.aribon.presentation.mapper.ViewModelMapper
import me.aribon.library.ui.model.MediaItemViewModel

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class BookItemViewModelMapper : ViewModelMapper<MediaEntity, MediaItemViewModel>() {

  override fun toEntity(value: MediaItemViewModel): MediaEntity {
    return MediaEntity(
        value.id,
        title = value.title,
        authors = value.authors,
        publisher = value.publisher,
        price = value.price,
        imageUrl = value.imageUrl
                      )
  }

  override fun fromEntity(value: MediaEntity): MediaItemViewModel {
    return MediaItemViewModel(
        id = value.id,
        title = value.title,
        publisher = value.publisher,
        authors = value.authors,
        price = value.price,
        imageUrl = value.imageUrl
                             )
  }
}