package me.aribon.ui.media.details

import io.reactivex.Single
import me.aribon.library.ui.model.MediaDetailsViewModel
import me.aribon.presentation.mapper.ViewModelMapper

/**
 * Created by anthony.ribon
 * On 20/03/2019
 */
interface MediaDetailsUseCase {
  fun <ENTITY: Any, MAPPER: ViewModelMapper<ENTITY, MediaDetailsViewModel>> getMediaDetails(mediaId: String, mapper: MAPPER): Single<MediaDetailsViewModel>
}