package me.aribon.library.ui.main

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import me.aribon.library.R
import me.aribon.library.route.Router
import me.aribon.library.ui.base.BaseActivity
import me.aribon.library.ui.category_list.CategoryListFragment

class MainActivity : BaseActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      val w = window // in Activity's onCreate() for instance
      w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                 WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    Router().openFragment(this, CategoryListFragment.newInstance())
  }

  override fun onWindowFocusChanged(hasFocus: Boolean) {
    super.onWindowFocusChanged(hasFocus)
  }

  override fun getLayoutRessource(): Int {
    return R.layout.activity_main
  }

  override fun onBackPressed() {
    Router().onBackPressed(this)
  }
}
