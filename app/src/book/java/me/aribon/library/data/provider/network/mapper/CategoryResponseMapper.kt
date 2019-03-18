package me.aribon.library.data.provider.network.mapper

import me.aribon.data_glose.provider.network.Response.CategoryResponse
import me.aribon.data.repository.mapper.RepositoryMapper
import me.aribon.domain_library.model.CategoryEntity

class CategoryResponseMapper: RepositoryMapper<CategoryEntity, CategoryResponse>() {
  override fun map(value: CategoryResponse): CategoryEntity {
    return CategoryEntity(
        value.id,
        value.label,
        0
                         )
  }
}