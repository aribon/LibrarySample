package me.aribon.library.data.repository

import io.reactivex.Single
import me.aribon.data_glose.repository.GloseRepository
import me.aribon.domain_library.model.CategoryEntity
import me.aribon.domain_library.model.MediaEntity
import me.aribon.domain_library.repository.MediaRepository
import me.aribon.library.data.provider.network.mapper.BookResponseMapper
import me.aribon.library.data.provider.network.mapper.CategoryResponseMapper

/**
 * Created by anthony.ribon
 * On 13/03/2019
 */
class AppRepository : GloseRepository(), MediaRepository {

  override fun searchMedia(search: String): Single<Collection<MediaEntity>> {
    throw NotImplementedError()
  }

  override fun getMediaList(id: String): Single<Collection<MediaEntity>> {
    return getBookList(id, BookResponseMapper())
  }

  override fun getCategoryList(): Single<Collection<CategoryEntity>> {
    return getCategoryList(CategoryResponseMapper())
  }

  override fun getMedia(id: String): Single<MediaEntity> {
    return getBook(id, BookResponseMapper())
  }
}



