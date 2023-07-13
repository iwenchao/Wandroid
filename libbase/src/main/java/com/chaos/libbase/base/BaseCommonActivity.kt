package com.chaos.libbase.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chaos.libbase.callback.ILoadingView
import com.chaos.libbase.callback.IPageAction
import com.chaos.libbase.ext.dismissLoadingExt
import com.chaos.libbase.ext.showLoadingExt

/**
 * @Author      : wen
 * @Email       : iwenchaos6688@163.com
 * @Date        : on 2023/6/29 08:57.
 * @Description :描述
 */
abstract class BaseCommonActivity : AppCompatActivity(), IPageAction, ILoadingView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onStart() {
        super.onStart()
        pageEnter()
    }


    override fun onStop() {
        super.onStop()
        pageExit()
    }

    override fun showLoading(msg: String) {
        showLoadingExt(msg)
    }

    override fun hideLoading() {
        dismissLoadingExt()
    }


    /**
     * 页面进入
     */
    override fun pageEnter() {

    }

    override fun pageVisibleChanged(visible: Boolean) {
    }

    /**
     * 页面退出
     */
    override fun pageExit() {
    }
}