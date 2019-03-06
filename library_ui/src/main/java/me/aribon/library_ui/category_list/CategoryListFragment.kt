package me.aribon.library_ui.category_list

import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_category_list.*
import me.aribon.core_ui.BaseFragment
import me.aribon.library_ui.R
import me.aribon.library_ui.model.CategoryItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class CategoryListFragment :
    BaseFragment(),
    CategoryListContract.View,
    CategoryAdapter.CategoryAdapterListener{

    private lateinit var presenter: CategoryListContract.Presenter

    override fun getLayoutRessource(): Int {
        return R.layout.content_category_list
    }

    override fun setPresenter(presenter: CategoryListContract.Presenter) {
        this.presenter = presenter
    }

    override fun initializePresenter() {
        super.initializePresenter()
        CategoryListPresenter(this)
    }

    override fun initializeView() {
        super.initializeView()
    }

    override fun renderList(categoryList: Array<CategoryItemViewModel>) {
        val adapter = CategoryAdapter(requireContext(), categoryList, this)
        recyclerCategoryList.layoutManager = LinearLayoutManager(requireContext())
        recyclerCategoryList.adapter = adapter
    }

    override fun onCategoryItemClick(categoryItemViewModel: CategoryItemViewModel) {
        presenter.onCategorySelected(categoryItemViewModel)
    }
}