package me.aribon.library.ui.main

import android.os.Bundle
import me.aribon.library.R
import me.aribon.library.route.Router
import me.aribon.library.ui.base.BaseActivity
import me.aribon.library.ui.category_list.CategoryListFragment

class MainActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Router().openFragment(this, CategoryListFragment.newInstance())
  }

  override fun getLayoutRessource(): Int {
    return R.layout.activity_main
  }
}
