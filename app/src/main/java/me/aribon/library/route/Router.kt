package me.aribon.library.route

import me.aribon.library.R
import me.aribon.library.ui.base.BaseActivity
import me.aribon.library.ui.base.BaseFragment
import me.aribon.library.ui.category_list.CategoryListFragment

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
        .replace(R.id.mainFragmentContainer, fragment)
        .addToBackStack(null)
        .commit()
  }

  fun <F: BaseFragment> openFragment(currentFragment: F, fragment: F) {

    currentFragment.requireActivity()
        .supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                             android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(R.id.mainFragmentContainer, fragment)
        .addToBackStack(null)
        .commit()
  }

  fun onBackPressed(baseActivity: BaseActivity) {
    val fm = baseActivity.supportFragmentManager
    if (fm.findFragmentById(R.id.mainFragmentContainer) is CategoryListFragment)
      baseActivity.finish()
    else
      fm.popBackStack()
  }
}