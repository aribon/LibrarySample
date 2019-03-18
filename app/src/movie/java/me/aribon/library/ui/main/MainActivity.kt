package me.aribon.library.ui.main

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import me.aribon.library.R
import me.aribon.library.route.Router
import me.aribon.library.ui.base.AppActivity
import me.aribon.library.ui.media.list.MediaListFragment

class MainActivity : AppActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      val w = window // in Activity's onCreate() for instance
      w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                 WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    Router().openFragment(this, MediaListFragment.newInstance("none"))
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
