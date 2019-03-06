package me.aribon.library

import me.aribon.redux.Action

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
sealed class AppAction: Action {
    class GoToHome(): AppAction()
    class DisplayCategoryList(): AppAction()
    class SelectCategory(): AppAction()
    class SelectBook(): AppAction()
}