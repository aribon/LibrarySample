package me.aribon.library_ui.book_details

import me.aribon.library_ui.base.AppPresenter
import me.aribon.library_ui.base.AppView

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
interface BookDetailsContract {

    interface View: AppView<Presenter> {
        fun renderTitle(title: String)
        fun renderAuthor(author: String)
        fun renderPublisher(publisher: String)
        fun renderCategory(category: String)
        fun renderDescription(description: String)
        fun renderPrice(price: Double)
    }

    interface Presenter: AppPresenter {

    }
}