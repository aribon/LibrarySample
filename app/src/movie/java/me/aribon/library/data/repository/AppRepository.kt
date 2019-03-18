package me.aribon.library.data.repository

import com.insign.clean.data.repository.OmdbRepository
import io.reactivex.Single
import me.aribon.domain_library.model.CategoryEntity
import me.aribon.domain_library.model.MediaEntity
import me.aribon.domain_library.repository.MediaRepository
import me.aribon.library.data.provider.network.mapper.MovieResponseMapper

/**
 * Created by anthony.ribon
 * On 13/03/2019
 */
class AppRepository : OmdbRepository(), MediaRepository {

  override fun searchMedia(search: String): Single<Collection<MediaEntity>> {
    return searchMovie(search, MovieResponseMapper())
  }

  override fun getCategoryList(): Single<Collection<CategoryEntity>> {
    throw NotImplementedError()
  }

  override fun getMediaList(categoryId: String): Single<Collection<MediaEntity>> {
    return searchMovie("Avengers", MovieResponseMapper())
  }

  override fun getMedia(id: String): Single<MediaEntity> {
    return getMovie(id, MovieResponseMapper())
  }
}



