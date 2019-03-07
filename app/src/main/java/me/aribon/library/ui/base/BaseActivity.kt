package me.aribon.library.ui.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
open abstract class BaseActivity : AppCompatActivity() {

  protected abstract fun getLayoutRessource(): Int

  protected open fun findViews() {
  }

  protected open fun initializePresenter() {
  }

  protected open fun initializeData() {
  }

  protected open fun initializeView() {
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayoutRessource())
    initializePresenter()
    findViews()
    initializeData()
    initializeView()
  }
}