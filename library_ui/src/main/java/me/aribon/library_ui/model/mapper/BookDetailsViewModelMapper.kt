package me.aribon.library_ui.model.mapper

import me.aribon.library_domain.model.BookEntity
import me.aribon.library_ui.model.BookDetailsViewModel

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class BookDetailsViewModelMapper : Mapper<BookEntity, BookDetailsViewModel>() {

    override fun toEntity(value: BookDetailsViewModel): BookEntity {
        return BookEntity(
            value.id,
            title = value.title,
            authors = value.authors,
            publisher = value.publisher,
            description = value.description,
            price = value.price
        )
    }

    override fun fromEntity(value: BookEntity): BookDetailsViewModel {
        return BookDetailsViewModel(
            id = value.id,
            title = value.title,
            category = "",
            publisher = value.publisher,
            authors = value.authors,
            description = value.description,
            price = value.price
        )
    }
}