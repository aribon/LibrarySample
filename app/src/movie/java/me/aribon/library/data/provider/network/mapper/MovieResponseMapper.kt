package me.aribon.library.data.provider.network.mapper

import com.insign.clean.data.provider.network.Response
import com.insign.clean.data.provider.network.Response.MovieResponse
import me.aribon.data.repository.mapper.RepositoryMapper
import me.aribon.domain_library.model.MediaEntity

/**
 * Created by anthony.ribon
 * On 01/03/2019
 */
class MovieResponseMapper : RepositoryMapper<MediaEntity, Response.MovieResponse>() {

  override fun map(value: MovieResponse): MediaEntity {
    return MediaEntity(
        id = value.id,
        title = value.title ?: "",
        year = value.year ?: "",
        type = value.type ?: "",
        imageUrl = value.poster ?: "",
        released = value.released ?: "",
        genre = value.genre ?: "",
        director = value.director?.let { listOf(it) } ?: emptyList(),
        writer = value.writer?.let { listOf(it) } ?: emptyList(),
        actors = value.actors?.let { listOf(it) } ?: emptyList(),
        language = value.language ?: "",
        country = value.country ?: "",
        awards = value.awards?.let { listOf(it) } ?: emptyList(),
        rating = value.rating ?: "",
        votes = value.votes ?: "",
        totalSeasons = value.totalSeasons?.toInt() ?: 0
                      )
  }
}