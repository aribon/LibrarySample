package me.aribon.domain_library.repository

import io.reactivex.Single
import me.aribon.domain_library.model.MediaEntity
import me.aribon.domain_library.model.CategoryEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
interface MediaRepository {
    fun getCategoryList(): Single<Collection<CategoryEntity>>
    fun searchMedia(search: String): Single<Collection<MediaEntity>>
    fun getMediaList(categoryId: String): Single<Collection<MediaEntity>>
    fun getMedia(id: String): Single<MediaEntity>
}