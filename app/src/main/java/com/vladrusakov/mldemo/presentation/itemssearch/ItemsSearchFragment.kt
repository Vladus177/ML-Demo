package com.vladrusakov.mldemo.presentation.itemssearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.vladrusakov.base.fragment.BaseViewBindingFragment
import com.vladrusakov.common.extensions.load
import com.vladrusakov.common.extensions.navigateTo
import com.vladrusakov.common.extensions.setDebounceClickListener
import com.vladrusakov.mldemo.databinding.FragmentSearchItemsBinding
import com.vladrusakov.mldemo.domain.model.LastSearch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemsSearchFragment : BaseViewBindingFragment<FragmentSearchItemsBinding>() {

    private val viewModel by viewModel<ItemsSearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSearchItemsBinding.inflate(inflater, container, false)
        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.uiState().observe(viewLifecycleOwner, { viewStateObserver(it) })
        viewModel.getLastSearch()
    }

    private fun viewStateObserver(viewState: ItemsSearchViewState) {
        when (viewState) {
            is ItemsSearchViewState.SuccessFetchLastSearch -> {
                renderLastSearch(viewState.lastSearch)
            }
            else -> viewBinding?.cvLastSearch?.isVisible = false
        }
    }

    private fun renderLastSearch(lastSearch: LastSearch) {
        viewBinding?.apply {
            cvLastSearch.isVisible = true
            tvProductTitle.text = lastSearch.description
            ivProduct.load(lastSearch.thumbnail)
            llContent.setDebounceClickListener { navigateToDetail(lastSearch.permalink) }
        }
    }

    private fun navigateToDetail(url: String) {
        val direction = ItemsSearchFragmentDirections.searchToDetail(url)
        view?.navigateTo(direction)
    }
}
