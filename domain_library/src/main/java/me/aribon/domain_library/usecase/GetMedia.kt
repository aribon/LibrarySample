package me.aribon.domain_library.usecase

import io.reactivex.Single
import me.aribon.domain_library.repository.MediaRepository
import me.aribon.domain_library.model.MediaEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class GetMedia(private val repository: MediaRepository) {

    fun execute(id: String): Single<MediaEntity> {
        return repository
            .getMedia(id)
    }
}