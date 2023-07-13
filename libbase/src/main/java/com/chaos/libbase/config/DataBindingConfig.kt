package com.chaos.libbase.config

import android.util.SparseArray
import androidx.lifecycle.ViewModel
import java.util.Objects

/**
 * @Author      : wen
 * @Email       : iwenchaos6688@163.com
 * @Date        : on 2023/6/29 09:24.
 * @Description :描述
 */
class DataBindingConfig(
    val layoutId: Int,
    val vmVariableId: Int,
    val stateViewModel: ViewModel

) {
    private val bindingParams = SparseArray<Objects>()

    fun addBindingParam(variableId: Int, obj: Objects): DataBindingConfig {
        if (bindingParams.get(variableId) == null) {
            bindingParams.put(variableId, obj)
        }
        return this
    }

    fun getBindingParam(): SparseArray<Objects> {
        return bindingParams;
    }

}