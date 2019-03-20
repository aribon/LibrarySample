package me.aribon.library.ui.model

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
data class MediaItemViewModel(
    val id: String,
    val title: String,
    val authors: Collection<String>,
    val publisher: Collection<String>,
    val price: Double,
    val imageUrl: String
                             )