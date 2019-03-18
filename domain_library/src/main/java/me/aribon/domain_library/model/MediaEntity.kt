package me.aribon.domain_library.model

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
data class MediaEntity(
    val id: String,
    val type: String = "",
    val title: String = "",
    val shortTitle: String = "",
    val authors: Collection<String> = emptyList(),
    val writer: Collection<String> = emptyList(),
    val director: Collection<String> = emptyList(),
    val publisher: Collection<String> = emptyList(),
    val actors: Collection<String> = emptyList(),
    val awards: Collection<String> = emptyList(),
    val year: String = "",
    val genre: String = "",
    val description: String = "",
    val released: String = "",
    val language: String = "",
    val country: String = "",
    val totalSeasons: Int = 0,
    val poster: String = "",
    val imageUrl: String = "",
    val price: Double = 0.0,
    val rating: String = "",
    val votes: String = ""
                      )