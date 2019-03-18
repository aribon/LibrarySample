package me.aribon.library.ui.model.mapper

import me.aribon.domain_library.model.CategoryEntity
import me.aribon.presentation.mapper.ViewModelMapper
import me.aribon.library.ui.model.CategoryItemViewModel

/**
 * @Author: aribon
 * @Date: 06/03/2019
 */
class CategoryItemViewModelMapper : ViewModelMapper<CategoryEntity, CategoryItemViewModel>() {

  override fun toEntity(value: CategoryItemViewModel): CategoryEntity {
    return CategoryEntity(
        value.id,
        value.categoryLabel,
        value.mediasAvailable
                         )
  }

  override fun fromEntity(value: CategoryEntity): CategoryItemViewModel {
    return CategoryItemViewModel(
        value.id,
        value.label,
        value.bookAvailable
                                )
  }
}