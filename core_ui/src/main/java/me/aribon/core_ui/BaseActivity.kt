package me.aribon.core_ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @Author: aribon
 * @Date: 05/03/2019
 */
open class BaseActivity : AppCompatActivity() {

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
        findViews()
        initializeData()
        initializeView()
    }
}