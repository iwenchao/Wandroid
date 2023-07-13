package com.chaos.libbase.callback

/**
 * @Author      : wen
 * @Email       : iwenchaos6688@163.com
 * @Date        : on 2023/6/29 08:55.
 * @Description : 页面进入，退出。方便进行埋点
 */
interface IPageAction {

    fun pageEnter()

    fun pageVisibleChanged(visible: Boolean)

    fun pageExit()

}