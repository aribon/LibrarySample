package me.aribon.library_domain.`interface`

import io.reactivex.Single
import me.aribon.library_domain.model.BookEntity
import me.aribon.library_domain.model.CategoryEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
interface LibraryRepository {
    fun getCategoryList(): Single<Collection<CategoryEntity>>
    fun getBookList(id: String): Single<Collection<BookEntity>>
    fun getBook(id: String): Single<BookEntity>
}