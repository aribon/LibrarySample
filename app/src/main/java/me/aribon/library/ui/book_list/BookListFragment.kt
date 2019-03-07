package me.aribon.library.ui.book_list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.content_book_list.recyclerBookList
import me.aribon.library.R
import me.aribon.library.ui.base.BaseFragment
import me.aribon.library.ui.model.BookItemViewModel

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
class BookListFragment :
    BaseFragment(),
    BookListContract.View,
    BookAdapter.BookAdapterListener {

  companion object {

    const val CATEGORY_LIST_CATEGORY_ID = "category_list_category_id"

    fun newInstance(bookId: String): BookListFragment {
      val fragment = BookListFragment()
      val bundle = Bundle()
      bundle.putString(CATEGORY_LIST_CATEGORY_ID, bookId)
      return fragment
    }
  }

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

  override fun render(bookList: Array<BookItemViewModel>, isLoading: Boolean) {
    when {
      isLoading -> {

      }
      else -> {
        val adapter = BookAdapter(requireContext(), bookList, this)
        recyclerBookList.layoutManager = LinearLayoutManager(requireContext())
        recyclerBookList.adapter = adapter
      }
    }
  }

  override fun showError(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
        .show()
  }

  override fun onBookItemClick(bookItemViewModel: BookItemViewModel) {
    presenter.onBookSelected(bookItemViewModel)
  }
}