package me.aribon.library.ui.book_list

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.content_book_list.pgBookList
import kotlinx.android.synthetic.main.content_book_list.recyclerBookList
import kotlinx.android.synthetic.main.content_book_list.viewBookList
import kotlinx.android.synthetic.main.toolbar.toolbar_title
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
      fragment.arguments = bundle
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

  override fun initializeView() {
    super.initializeView()
//    toolbar_title.text = String.format(getString(R.string.tui_book_list_title))
  }

  override fun onStart() {
    super.onStart()
    presenter.subscribe()
  }

  override fun onStop() {
    presenter.unsubscribe()
    super.onStop()
  }

  override fun render(bookList: Array<BookItemViewModel>, isLoading: Boolean) {
    when {
      isLoading -> {
        viewBookList.visibility = View.GONE
        pgBookList.visibility = View.VISIBLE
      }
      else -> {
        pgBookList.visibility = View.GONE
        viewBookList.visibility = View.VISIBLE
        val adapter = BookAdapter(requireContext(), bookList, this)
        val llm = GridLayoutManager(requireContext(), 2)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerBookList.layoutManager = llm
        recyclerBookList.adapter = adapter
        runLayoutAnimation(recyclerBookList)
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

  private fun runLayoutAnimation(recyclerView: RecyclerView) {
    val context = recyclerView.context
    val controller = AnimationUtils
        .loadLayoutAnimation(context, R.anim.layout_animation_fall_down)

    recyclerView.layoutAnimation = controller
    recyclerView.adapter!!.notifyDataSetChanged()
    recyclerView.scheduleLayoutAnimation()
  }
}