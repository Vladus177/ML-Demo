package com.vladrusakov.mldemo.presentation.itemslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.vladrusakov.base.fragment.BaseViewBindingFragment
import com.vladrusakov.common.extensions.navigateTo
import com.vladrusakov.mldemo.R
import com.vladrusakov.mldemo.databinding.FragmentItemsListBinding
import com.vladrusakov.mldemo.presentation.itemslist.ItemsListViewState.*
import com.vladrusakov.mldemo.presentation.model.Result
import com.vladrusakov.mldemo.presentation.model.SearchResponse
import com.vladrusakov.ui.view.AttrsEmptyView
import com.vladrusakov.ui.view.AttrsErrorView

class ItemsListFragment : BaseViewBindingFragment<FragmentItemsListBinding>(),
    OnProductItemClickListener {

    private val args: ItemsListFragmentArgs by navArgs()
    private val viewModel by viewModel<ItemsListViewModel>()
    private val productsAdapter = ItemsListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentItemsListBinding.inflate(inflater, container, false)
        return viewBinding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.uiState().observe(viewLifecycleOwner, { viewStateObserver(it) })
        viewModel.searchProducts(args.query)
        setupFragment()
    }

    private fun setupFragment() {
        viewBinding?.apply {
            rvProducts.adapter = productsAdapter
            rvProducts.layoutManager = StaggeredGridLayoutManager(
                PRODUCTS_SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL
            )
        }
    }

    private fun viewStateObserver(viewState: ItemsListViewState) {
        when (viewState) {
            is SuccessFetchProducts -> {
                renderProducts(viewState.searchResponse)
                viewBinding?.rvProducts?.isVisible = true
            }
            is GenericServiceError -> {
                val arg = AttrsErrorView(
                    title = getString(R.string.generic_error),
                    primaryButtonName = getString(R.string.try_again),
                    primaryButtonListener = { viewModel.searchProducts(args.query) })
                viewBinding?.errorView?.setAttrs(arg)
            }
            is NetworkError -> {
                val arg = AttrsErrorView(
                    title = getString(R.string.looks_like_connection_error),
                    message = getString(R.string.check_your_connection),
                    primaryButtonName = getString(R.string.try_again),
                    primaryButtonListener = { viewModel.searchProducts(args.query) })
                viewBinding?.errorView?.setAttrs(arg)
            }
            is Empty -> {
                val args = AttrsEmptyView(
                    title = getString(R.string.publications_not_found),
                    message = getString(R.string.check_input)
                )
                viewBinding?.emptyView?.setAttrs(args)
            }
            else -> viewBinding?.rvProducts?.isVisible = false
        }
        viewBinding?.apply {
            errorView.isVisible = viewState.isError
            emptyView.isVisible = viewState.isEmpty
            loadingView.isVisible = viewState.isLoading
        }
    }

    private fun renderProducts(searchResult: SearchResponse) {
        productsAdapter.setItems(searchResult.results)
    }

    override fun productClick(product: Result) {
        val direction = ItemsListFragmentDirections.listToDetail(product.permalink)
        view?.navigateTo(direction)
    }

    companion object {
        const val PRODUCTS_SPAN_COUNT = 2
    }
}
