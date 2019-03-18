package me.aribon.library.ui.category.list

import io.reactivex.android.schedulers.AndroidSchedulers
import me.aribon.domain_library.usecase.GetCategoryList
import me.aribon.library.App
import me.aribon.library.data.repository.AppRepository
import me.aribon.library.redux.action.CategoryListAction
import me.aribon.library.redux.state.CategoryListState
import me.aribon.library.route.Router
import me.aribon.library.ui.model.mapper.CategoryItemViewModelMapper
import me.aribon.redux.core.State
import me.aribon.redux.core.StoreSubscriber
import me.aribon.library.ui.base.BaseAppPresenter
import me.aribon.library.ui.media.list.MediaListFragment
import me.aribon.library.ui.category.list.CategoryListContract.Presenter
import me.aribon.library.ui.category.list.CategoryListContract.View
import me.aribon.library.ui.model.CategoryItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class CategoryListPresenter(
    val view: View,
    private val getCategoryList: GetCategoryList = GetCategoryList(AppRepository()))
  : BaseAppPresenter(),
    Presenter,
    StoreSubscriber {

  init {
    view.setPresenter(this)
  }

  override fun subscribe() {
    super.subscribe()
    App.instance.getStore()
        .subscribe(this)

    App.instance
        .getStore()
        .dispatch(CategoryListAction.Fetch())
  }

  override fun unsubscribe() {
    super.unsubscribe()
    App.instance.getStore()
        .unsubscribe(this)
  }

  override fun onCategorySelected(categoryItemViewModel: CategoryItemViewModel) {
    App.instance
        .getStore()
        .dispatch(CategoryListAction.Select(categoryItemViewModel.id))
  }

  private fun getCategoryList() {
    executeRequest(
        getCategoryList.execute()
            .observeOn(AndroidSchedulers.mainThread())
            .map { CategoryItemViewModelMapper().fromEntity(it) }
            .subscribe(
                {
                  App.instance
                      .getStore()
                      .dispatch(CategoryListAction.Display(it))
                },
                {
                  view.showError("Une erreur s'est produite")
                }
                      )
                  )
  }

  override fun onStateChange(newState: State) {
    when (newState) {
      is CategoryListState -> {
        when {
          newState.isFetching -> {
            view.render(newState.viewModelList.toTypedArray(), true)
            getCategoryList()
          }
          newState.isRender   -> view.render(newState.viewModelList.toTypedArray(), false)
          newState.isSelected -> App.instance
              .getStore()
              .dispatch(CategoryListAction.Navigate(newState.categorySelectedId))
          newState.isNavigate -> Router().openFragment(
              (view as CategoryListFragment),
              MediaListFragment.newInstance(newState.categorySelectedId))
        }
      }
    }
  }
}