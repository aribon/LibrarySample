package me.aribon.library.redux.action

import me.aribon.library.redux.base.Action
import me.aribon.library.ui.model.CategoryItemViewModel

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
sealed class CategoryListAction : Action {

  class Fetch : CategoryListAction()
  class Display(viewModel: Collection<CategoryItemViewModel>) : CategoryListAction()
  class Select(val categoryId: String) : CategoryListAction()
  class Navigate(val categoryId: String) : CategoryListAction()
}