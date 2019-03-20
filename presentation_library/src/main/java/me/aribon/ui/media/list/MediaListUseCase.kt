package me.aribon.ui.media.list

import io.reactivex.Single
import me.aribon.library.ui.model.MediaItemViewModel
import me.aribon.presentation.mapper.ViewModelMapper

/**
 * Created by anthony.ribon
 * On 20/03/2019
 */
interface MediaListUseCase {
  fun <ENTITY: Any, MAPPER: ViewModelMapper<ENTITY, MediaItemViewModel>> getMediaItemList(categoryId: String, mapper: MAPPER): Single<Collection<MediaItemViewModel>>
}