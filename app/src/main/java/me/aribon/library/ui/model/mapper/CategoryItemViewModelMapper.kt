package me.aribon.library.ui.model.mapper

import me.aribon.library.domain.model.CategoryEntity
import me.aribon.library.ui.model.CategoryItemViewModel

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class CategoryItemViewModelMapper : Mapper<CategoryEntity, CategoryItemViewModel>() {

  override fun toEntity(value: CategoryItemViewModel): CategoryEntity {
    return CategoryEntity(
        value.id,
        value.categoryLabel
                         )
  }

  override fun fromEntity(value: CategoryEntity): CategoryItemViewModel {
    return CategoryItemViewModel(
        value.id,
        value.label,
        0
                                )
  }
}