package me.aribon.library.domain.usecase

import io.reactivex.Flowable
import io.reactivex.Single
import me.aribon.library.domain.`interface`.LibraryRepository
import me.aribon.library.domain.model.BookEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class GetBookList(private val repository: LibraryRepository) {

    fun execute(id: String): Single<Collection<BookEntity>> {
        return repository.getBookList(id)
            .flatMap { rawBookList ->
                Flowable.fromIterable(rawBookList)
                    .flatMapSingle { repository.getBook(it) }
                    .toList()
            }.map {
              it.sortBy { it.id }
              it
            }
    }
}