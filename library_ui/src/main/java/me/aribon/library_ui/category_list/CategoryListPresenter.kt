package me.aribon.library_ui.category_list

import me.aribon.library_domain.usecase.GetCategoryList
import me.aribon.library_ui.base.BaseAppPresenter
import me.aribon.library_ui.model.CategoryItemViewModel
import me.aribon.library_ui.model.mapper.CategoryItemViewModelMapper

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class CategoryListPresenter(
    val view: CategoryListContract.View,
    private val getCategoryList: GetCategoryList)
    : BaseAppPresenter(),
    CategoryListContract.Presenter {

    init {
        view.setPresenter(this)
    }

    override fun subscribe() {
        getCategoryList()
    }

    override fun unsubscribe() {

    }

    override fun onCategorySelected(categoryItemViewModel: CategoryItemViewModel) {
        //TODO change state
    }

    private fun getCategoryList() {
        executeRequest(
            getCategoryList.execute()
                .map { CategoryItemViewModelMapper().fromEntity(it) }
                .subscribe(
                    { view.renderList(it.toTypedArray()) },
                    { view.showError("Une erreur s'est produite") }
                )
        )
    }
}