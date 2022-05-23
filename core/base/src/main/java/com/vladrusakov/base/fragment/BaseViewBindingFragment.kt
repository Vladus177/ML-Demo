package com.vladrusakov.base.fragment

abstract class BaseViewBindingFragment<VB> : BaseFragment() {

    protected var viewBinding: VB? = null

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}