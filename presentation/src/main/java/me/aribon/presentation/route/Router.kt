package me.aribon.presentation.route

import me.aribon.ui_library.base.BaseActivity
import me.aribon.ui_library.base.BaseFragment

/**
 * Created by anthony.ribon
 * On 07/03/2019
 */
class Router<ACTIVITY: BaseActivity, FRAGMENT: BaseFragment> {

  fun <A: ACTIVITY, F: FRAGMENT> openFragment(activity: A, fragment: F, containerResId: Int) {

    activity
        .supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                             android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(containerResId, fragment)
//        .replace(R.id.mainFragmentContainer, fragment)
        .addToBackStack(null)
        .commit()
  }

  fun <F: FRAGMENT> openFragment(currentFragment: F, fragment: F, containerResId: Int) {

    currentFragment.requireActivity()
        .supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out,
                             android.R.anim.fade_in, android.R.anim.fade_out)
        .replace(containerResId, fragment)
        .addToBackStack(null)
        .commit()
  }

  fun onBackPressed(baseActivity: ACTIVITY, condition: Boolean) {
    val fm = baseActivity.supportFragmentManager
    if (condition)
//    if (fm.findFragmentById(R.id.mainFragmentContainer) is CategoryListFragment)
      baseActivity.finish()
    else
      fm.popBackStack()
  }
}