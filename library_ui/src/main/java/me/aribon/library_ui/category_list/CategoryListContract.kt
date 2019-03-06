package me.aribon.library_ui.category_list

import me.aribon.library_ui.base.AppPresenter
import me.aribon.library_ui.base.AppView
import me.aribon.library_ui.model.CategoryItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
interface CategoryListContract {

    interface View: AppView<Presenter> {
        fun renderList(categoryList: Array<CategoryItemViewModel>)
    }

    interface Presenter: AppPresenter {
        fun onCategorySelected(categoryItemViewModel: CategoryItemViewModel)
    }
}