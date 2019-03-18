package me.aribon.domain_library.usecase

import io.reactivex.Single
import me.aribon.domain_library.repository.MediaRepository
import me.aribon.domain_library.model.MediaEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
open class GetMediaList(private val repository: MediaRepository) {

    fun execute(id: String): Single<Collection<MediaEntity>> {
        return repository
            .getMediaList(id)
            .map {
                it.sortedBy { it.title }
                it
            }
    }
}