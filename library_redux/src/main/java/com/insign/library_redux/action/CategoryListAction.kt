package com.insign.library_redux.action

import me.aribon.redux.Action

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
sealed class CategoryListAction: Action {
  class Fetch: CategoryListAction()
  class Display: CategoryListAction()
  class Select(val categoryId: String): CategoryListAction()
  class Navigate: CategoryListAction()
}