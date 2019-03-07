package me.aribon.library.data.provider.network.mapper

import me.aribon.library.data.provider.network.Response
import me.aribon.library.data.provider.network.Response.CategoryResponse
import me.aribon.library.data.repository.mapper.Mapper
import me.aribon.library.domain.model.CategoryEntity

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class CategoryMapper : Mapper<CategoryEntity, CategoryResponse>() {

  override fun map(value: Response.CategoryResponse): CategoryEntity {
    return CategoryEntity(
        value.id,
        value.label
                         )
  }
}