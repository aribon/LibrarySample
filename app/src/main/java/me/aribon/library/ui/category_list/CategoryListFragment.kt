package me.aribon.library.ui.category_list

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.content_category_list.pgCategoryList
import kotlinx.android.synthetic.main.content_category_list.recyclerCategoryList
import kotlinx.android.synthetic.main.content_category_list.tvCategoryListTitle
import kotlinx.android.synthetic.main.content_category_list.viewCategoryList
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
    tvCategoryListTitle.text = String.format(getString(R.string.tui_category_list_title))
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
        viewCategoryList.visibility = View.GONE
        pgCategoryList.visibility = View.VISIBLE
      }
      else -> {
        pgCategoryList.visibility = View.GONE
        viewCategoryList.visibility = View.VISIBLE
        val adapter = CategoryAdapter(requireContext(), categoryList, this)
        val llm = LinearLayoutManager(requireContext())
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerCategoryList.layoutManager = llm
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