package me.aribon.library.route

import me.aribon.library.ui.base.BaseActivity
import me.aribon.library.ui.base.BaseFragment

/**
 * Created by anthony.ribon
 * On 07/03/2019
 */
class Router {

  fun <A: BaseActivity, F: BaseFragment> openFragment(activity: A, fragment: F) {

    activity
        .supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                             android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(android.R.id.content, fragment)
        .addToBackStack(null)
        .commit()
  }

  fun <F: BaseFragment> openFragment(currentFragment: F, fragment: F) {

    currentFragment.requireActivity()
        .supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                             android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(android.R.id.content, fragment)
        .addToBackStack(null)
        .commit()
  }
}