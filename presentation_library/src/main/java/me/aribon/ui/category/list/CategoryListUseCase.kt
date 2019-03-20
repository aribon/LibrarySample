package me.aribon.ui.category.list

import io.reactivex.Single
import me.aribon.library.ui.model.CategoryItemViewModel
import me.aribon.presentation.mapper.ViewModelMapper

/**
 * Created by anthony.ribon
 * On 20/03/2019
 */
interface CategoryListUseCase {
  fun <ENTITY: Any, MAPPER: ViewModelMapper<ENTITY, CategoryItemViewModel>> getCategoryItemList(mapper: MAPPER) : Single<Collection<CategoryItemViewModel>>
}