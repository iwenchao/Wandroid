package com.chaos.libbase.base

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chaos.libbase.ext.getVmClazz
import com.chaos.libbase.vm.BaseViewModel

/**
 * @Author      : wen
 * @Email       : iwenchaos6688@163.com
 * @Date        : on 2023/7/4 12:17.
 * @Description :描述
 */
abstract class BaseVMActivity<VM : BaseViewModel> : BaseDataBindingActivity() {

    lateinit var viewModel: VM

    abstract fun initViews()

    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
        registerUiChange()
        initViews()
        initData()

    }


    /**
     * 创建viewModel
     */
    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this))
    }


    /**
     * 注册 UI 事件
     */
    private fun registerUiChange() {
        //显示弹窗
        viewModel.loadingChange.showLoading.observe(this, Observer {
            showLoading(
                if (it.isEmpty()) {
                    "请求网络中..."
                } else it
            )
        })
        //关闭弹窗
        viewModel.loadingChange.hideLoading.observe(this, Observer {
            hideLoading()
        })
    }


}