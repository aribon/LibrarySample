package com.insign.library_redux.action

import me.aribon.redux.Action

/**
 * Created by anthony.ribon
 * On 06/03/2019
 */
sealed class BookDetailsAction: Action {
  class Fetch: BookDetailsAction()
  class Display: BookDetailsAction()
  class Navigate: BookDetailsAction()
}