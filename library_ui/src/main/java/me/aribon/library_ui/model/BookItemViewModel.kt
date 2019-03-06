package me.aribon.library_ui.model

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
data class BookItemViewModel(
    val id: String,
    val title: String,
    val authors: Collection<String>,
    val publisher: String,
    val price: Double
)