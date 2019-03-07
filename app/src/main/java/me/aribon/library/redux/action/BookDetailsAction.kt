package me.aribon.library.redux.action

import me.aribon.library.redux.base.Action
import me.aribon.library.ui.model.BookDetailsViewModel

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
sealed class BookDetailsAction : Action {

  class Fetch(val bookId: String) : BookDetailsAction()
  class Display(val viewModel: BookDetailsViewModel) : BookDetailsAction()
  class Navigate : BookDetailsAction()
}