package me.aribon.library_domain.model

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
data class BookEntity(
    val id: String,
    val title: String = "",
    val shortTitle: String = "",
    val authors: Collection<String> = emptyList(),
    val publisher: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val imageUrl: String = ""
)