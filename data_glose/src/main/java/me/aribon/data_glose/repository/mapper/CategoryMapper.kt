package me.aribon.data_glose.repository.mapper

import me.aribon.data_glose.provider.network.Response
import me.aribon.library_domain.model.CategoryEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class CategoryMapper: Mapper<CategoryEntity, Response.CategoryResponse>() {

    override fun map(value: Response.CategoryResponse): CategoryEntity {
        return CategoryEntity(
            value.id,
            value.label
        )
    }
}