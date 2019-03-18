package me.aribon.library.ui.category.list

import me.aribon.library.ui.base.AppPresenter
import me.aribon.library.ui.base.AppView
import me.aribon.library.ui.model.CategoryItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
interface CategoryListContract {

  interface View : AppView<Presenter> {
    fun render(categoryList: Array<CategoryItemViewModel>, isLoading: Boolean)
  }

  interface Presenter : AppPresenter {
    fun onCategorySelected(categoryItemViewModel: CategoryItemViewModel)
  }
}