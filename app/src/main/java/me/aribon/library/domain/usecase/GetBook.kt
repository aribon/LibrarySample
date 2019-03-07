package me.aribon.library_domain.usecase

import io.reactivex.Single
import me.aribon.library.domain.`interface`.LibraryRepository
import me.aribon.library.domain.model.BookEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class GetBook(private val repository: LibraryRepository) {

    fun execute(id: String): Single<BookEntity> {
        return repository.getBook(id)
    }
}