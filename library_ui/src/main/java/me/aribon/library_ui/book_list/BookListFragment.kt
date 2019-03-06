package me.aribon.library_ui.book_list

import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.content_book_list.*
import me.aribon.core_ui.BaseFragment
import me.aribon.library_ui.R
import me.aribon.library_ui.model.BookItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class BookListFragment:
    BaseFragment(),
    BookListContract.View,
    BookAdapter.BookAdapterListener {

    private lateinit var presenter: BookListContract.Presenter

    override fun getLayoutRessource(): Int {
        return R.layout.content_book_list
    }

    override fun setPresenter(presenter: BookListContract.Presenter) {
        this.presenter = presenter
    }

    override fun initializePresenter() {
        super.initializePresenter()
        BookListPresenter(this)
    }

    override fun renderList(bookList: Array<BookItemViewModel>) {
        val adapter = BookAdapter(requireContext(), bookList, this)
        recyclerBookList.layoutManager = LinearLayoutManager(requireContext())
        recyclerBookList.adapter = adapter
    }

    override fun onBookItemClick(bookItemViewModel: BookItemViewModel) {
        presenter.onBookSelected(bookItemViewModel)
    }
}