package me.aribon.ui.category.list

import io.reactivex.android.schedulers.AndroidSchedulers
import me.aribon.library.ui.base.BaseAppPresenter
import me.aribon.library.ui.category.list.CategoryListContract.Presenter
import me.aribon.library.ui.category.list.CategoryListContract.View
import me.aribon.library.ui.category.list.CategoryListFragment
import me.aribon.library.ui.media.list.MediaListFragment
import me.aribon.library.ui.model.CategoryItemViewModel
import me.aribon.presentation.route.Router
import me.aribon.ui_library.R
import me.aribon.ui_library.base.BaseActivity
import me.aribon.ui_library.base.BaseFragment

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class CategoryListPresenter(
    val view: View,
    private val categoryListInteractor: CategoryListUseCase)
  : BaseAppPresenter(),
    Presenter {

  init {
    view.setPresenter(this)
  }

  override fun subscribe() {
    super.subscribe()
    getCategoryList()
  }

  override fun unsubscribe() {
    super.unsubscribe()
  }

  override fun onCategorySelected(categoryItemViewModel: CategoryItemViewModel) {
    Router<BaseActivity, BaseFragment>().openFragment(
        (view as CategoryListFragment),
        MediaListFragment.newInstance(categoryItemViewModel.id),
        R.id.mainFragmentContainer)

    //    App.instance
    //        .getStore()
    //        .dispatch(CategoryListAction.Select(categoryItemViewModel.id))
  }

  private fun getCategoryList() {
        executeRequest(
            categoryListInteractor.getCategoryItemList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {
                      view.render(it.toTypedArray(), false)
    //                  App.instance
    //                      .getStore()
    //                      .dispatch(CategoryListAction.Display(it))
                    },
                    {
                      view.showError("Une erreur s'est produite")
                    }
                          )
                      )
  }

  //  override fun onStateChange(newState: State) {
  //    when (newState) {
  //      is CategoryListState -> {
  //        when {
  //          newState.isFetching -> {
  //            view.render(newState.viewModelList.toTypedArray(), true)
  //            getCategoryList()
  //          }
  //          newState.isRender   -> view.render(newState.viewModelList.toTypedArray(), false)
  //          newState.isSelected -> App.instance
  //              .getStore()
  //              .dispatch(CategoryListAction.Navigate(newState.categorySelectedId))
  //          newState.isNavigate -> Router().openFragment(
  //              (view as CategoryListFragment),
  //              MediaListFragment.newInstance(newState.categorySelectedId))
  //        }
  //      }
  //    }
  //  }
}