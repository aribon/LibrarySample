package me.aribon.library_domain.usecase

import io.reactivex.Single
import me.aribon.library_domain.`interface`.LibraryRepository
import me.aribon.library_domain.model.BookEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class GetBookList(private val repository: LibraryRepository) {

    fun execute(id: String): Single<Collection<BookEntity>> {
        return repository.getBookList(id)
    }
}