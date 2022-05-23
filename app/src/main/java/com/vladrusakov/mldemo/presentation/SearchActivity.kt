package com.vladrusakov.mldemo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.vladrusakov.common.extensions.navigateTo
import com.vladrusakov.mldemo.R
import com.vladrusakov.mldemo.databinding.ActivitySearchBinding
import com.vladrusakov.mldemo.presentation.itemssearch.ItemsSearchFragmentDirections

class SearchActivity : AppCompatActivity() {

    private var navHostFragment = NavHostFragment()
    private lateinit var binding: ActivitySearchBinding

    private val listener =
        NavController.OnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.searchItems, R.id.itemsList -> {
                    binding.toolbarSearch.navigationIcon = null
                    binding.toolbarSearch.isVisible = true
                }
                else -> {
                    binding.toolbarSearch.isVisible = false
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNavigation()
        setupActivity()
    }

    override fun onResume() {
        super.onResume()
        navHostFragment.navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        super.onPause()
        navHostFragment.navController.removeOnDestinationChangedListener(listener)
    }

    override fun onBackPressed() {
        when (navHostFragment.navController.currentDestination?.id) {
            R.id.searchItems -> super.onBackPressed()
            else -> navHostFragment.navController.popBackStack()
        }
    }

    private fun setUpNavigation() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_search) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(),
            fallbackOnNavigateUpListener = ::onSupportNavigateUp
        )
        binding.toolbarSearch.setupWithNavController(navController, appBarConfiguration)

    }

    private fun setupActivity() {
        binding.searchView.apply {
            queryHint = getString(R.string.search_in_ml)
            setOnQueryTextFocusChangeListener { _, hasFocus ->
                if (hasFocus && navHostFragment.navController.currentDestination?.id == R.id.itemsList) {
                    navHostFragment.findNavController().popBackStack()
                }
            }
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    navigateToListItems(query)
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })
        }
    }

    private fun navigateToListItems(query: String) {
        if (navHostFragment.navController.currentDestination?.id == R.id.searchItems) {
            val direction = ItemsSearchFragmentDirections.searchToList(query)
            navHostFragment.findNavController().navigateTo(direction)
            binding.searchView.isFocusable = false
            binding.searchView.clearFocus()
        }
    }
}
