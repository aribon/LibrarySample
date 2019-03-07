package com.insign.library_redux.action

import me.aribon.redux.Action

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
sealed class BookListAction: Action {
  class Fetch: BookListAction()
  class Select(val bookId: String): BookListAction()
  class Display: BookListAction()
  class Navigate: BookListAction()
}