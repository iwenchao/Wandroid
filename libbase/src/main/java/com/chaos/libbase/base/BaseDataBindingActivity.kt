package com.chaos.libbase.base

import android.os.Bundle
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.chaos.libbase.config.DataBindingConfig

/**
 * @Author      : wen
 * @Email       : iwenchaos6688@163.com
 * @Date        : on 2023/6/29 09:16.
 * @Description :描述
 */
abstract class BaseDataBindingActivity : BaseCommonActivity() {

    private var binding: ViewDataBinding? = null

    abstract fun getDataBindingConfig(): DataBindingConfig


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dataBindingConfig = getDataBindingConfig()
        val binding =
            DataBindingUtil.setContentView<ViewDataBinding>(this, dataBindingConfig.layoutId)
        binding.lifecycleOwner = this
        binding.setVariable(dataBindingConfig.vmVariableId, dataBindingConfig.stateViewModel)
        val bindingParam = dataBindingConfig.getBindingParam()
        bindingParam.forEach { key, value ->
            binding.setVariable(key, value)
        }
        this.binding = binding
    }


    override fun onDestroy() {
        super.onDestroy()
        binding?.unbind()
        binding = null
    }

}