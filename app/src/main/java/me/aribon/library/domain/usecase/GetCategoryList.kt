package me.aribon.library.domain.usecase

import io.reactivex.Flowable
import io.reactivex.Single
import me.aribon.library.domain.`interface`.LibraryRepository
import me.aribon.library.domain.model.CategoryEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class GetCategoryList(private val repository: LibraryRepository) {

    fun execute(): Single<Collection<CategoryEntity>> {
        return repository.getCategoryList()
            .flatMap { categoryList ->
                Flowable.fromIterable(categoryList)
                    .flatMapSingle { category ->
                        repository.getBookList(category.id)
                            .map { category.copy(bookAvailable = it.size) }
                    }
                    .toList()
            }
            .map {
              it.sortBy { it.label }
              it
            }
    }
}