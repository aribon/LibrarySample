package me.aribon.library.ui.category_list

import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.content_category_list.recyclerCategoryList
import me.aribon.library.R
import me.aribon.library.ui.base.BaseFragment
import me.aribon.library.ui.model.CategoryItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class CategoryListFragment :
    BaseFragment(),
    CategoryListContract.View,
    CategoryAdapter.CategoryAdapterListener {

  companion object {
    fun newInstance(): CategoryListFragment {
      return CategoryListFragment()
    }
  }

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

  override fun onStart() {
    super.onStart()
    presenter.subscribe()
  }

  override fun onStop() {
    presenter.unsubscribe()
    super.onStop()
  }

  override fun render(categoryList: Array<CategoryItemViewModel>, isLoading: Boolean) {
    when {
      isLoading -> {

      }
      else -> {
        val adapter = CategoryAdapter(requireContext(), categoryList, this)
        recyclerCategoryList.layoutManager = LinearLayoutManager(requireContext())
        recyclerCategoryList.adapter = adapter
      }
    }
  }

  override fun showError(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
        .show()
  }

  override fun onCategoryItemClick(categoryItemViewModel: CategoryItemViewModel) {
    presenter.onCategorySelected(categoryItemViewModel)
  }
}