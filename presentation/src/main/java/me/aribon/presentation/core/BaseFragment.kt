package me.aribon.ui_library.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
open abstract class BaseFragment : Fragment() {

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
    initializePresenter()
  }

  override fun onCreateView(inflater: LayoutInflater,
                            container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(getLayoutRessource(), container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    findViews()
    initializeData()
    initializeView()
  }
}