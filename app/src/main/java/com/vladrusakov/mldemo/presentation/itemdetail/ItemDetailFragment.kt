package com.vladrusakov.mldemo.presentation.itemdetail

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.vladrusakov.base.fragment.BaseViewBindingFragment
import com.vladrusakov.mldemo.databinding.FragmentItemDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemDetailFragment : BaseViewBindingFragment<FragmentItemDetailBinding>() {

    private val args: ItemDetailFragmentArgs by navArgs()
    private val viewModel by viewModel<ItemDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentItemDetailBinding.inflate(inflater, container, false)
        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFragment()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupFragment() {
        viewBinding?.apply {
            wvDetail.settings.javaScriptEnabled = true
            wvDetail.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    showLoading(true)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    showLoading(false)
                }
            }
            wvDetail.loadUrl(args.itemUrl)
        }
    }

    private fun showLoading(loading: Boolean) {
        viewBinding?.apply {
            loadingView.isVisible = loading
            wvDetail.isVisible = !loading
        }
    }
}
