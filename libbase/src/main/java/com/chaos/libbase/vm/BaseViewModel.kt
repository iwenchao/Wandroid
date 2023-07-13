package com.chaos.libbase.vm

import androidx.lifecycle.ViewModel
import com.chaos.libbase.callback.livedata.event.EventLiveData

/**
 * @Author      : wen
 * @Email       : iwenchaos6688@163.com
 * @Date        : on 2023/7/4 12:19.
 * @Description :描述
 */
open class BaseViewModel : ViewModel() {
    val loadingChange: UiLoadingChange by lazy { UiLoadingChange() }

    inner class UiLoadingChange {
        val showLoading by lazy { EventLiveData<String>() }
        val hideLoading by lazy { EventLiveData<Boolean>() }
    }

}