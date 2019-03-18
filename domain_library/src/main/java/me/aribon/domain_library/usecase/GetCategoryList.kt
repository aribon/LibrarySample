package me.aribon.domain_library.usecase

import io.reactivex.Flowable
import io.reactivex.Single
import me.aribon.domain_library.repository.MediaRepository
import me.aribon.domain_library.model.CategoryEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class GetCategoryList(private val repository: MediaRepository) {

    fun execute(): Single<Collection<CategoryEntity>> {
        return repository.getCategoryList()
            .flatMap { categoryList ->
                Flowable.fromIterable(categoryList)
                    .flatMapSingle { category ->
                        repository.getMediaList(category.id)
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