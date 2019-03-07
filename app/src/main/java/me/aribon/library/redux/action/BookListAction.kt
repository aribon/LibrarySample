package me.aribon.library.redux.action

import me.aribon.library.redux.base.Action
import me.aribon.library.ui.model.BookItemViewModel

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
sealed class BookListAction : Action {

  class Fetch(val categoryId: String) : BookListAction()
  class Display(val viewModel: Collection<BookItemViewModel>) : BookListAction()
  class Select(val bookId: String) : BookListAction()
  class Navigate(val bookId: String) : BookListAction()
}