package com.insign.clean.data.repository

import com.insign.clean.data.provider.network.Response.MovieResponse
import com.insign.clean.data.provider.network.Service
import io.reactivex.Single
import me.aribon.data.repository.mapper.RepositoryMapper

/**
 * Created by anthony.ribon
 * On 01/03/2019
 */
open class OmdbRepository {

  protected fun <ENTITY : Any, MAPPER : RepositoryMapper<ENTITY, MovieResponse>>
      searchMovie(search: String, mapper: MAPPER): Single<Collection<ENTITY>> {
    return Service()
        .searchMovie(search)
        .map { mapper.map(it.searchResult) }
  }

  protected fun <ENTITY : Any, MAPPER : RepositoryMapper<ENTITY, MovieResponse>>
      getMovie(id: String, mapper: MAPPER): Single<ENTITY> {
    return Service()
        .getMovie(id)
        .map { mapper.map(it) }
  }
}