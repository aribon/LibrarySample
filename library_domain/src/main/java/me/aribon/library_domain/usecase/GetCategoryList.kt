package me.aribon.library_domain.usecase

import io.reactivex.Single
import me.aribon.library_domain.`interface`.LibraryRepository
import me.aribon.library_domain.model.CategoryEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class GetCategoryList(private val repository: LibraryRepository) {

    fun execute(): Single<Collection<CategoryEntity>> {
        return repository.getCategoryList()
    }
}