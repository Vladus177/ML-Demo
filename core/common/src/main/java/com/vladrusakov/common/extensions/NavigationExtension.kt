package com.vladrusakov.common.extensions

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController

fun View.navigateTo(direction: NavDirections) {
    this.findNavController().apply {
        currentDestination?.getAction(direction.actionId)?.let { navigate(direction) }
    }
}

fun NavController.navigateTo(direction: NavDirections) {
    this.apply {
        currentDestination?.getAction(direction.actionId)?.let { navigate(direction) }
    }
}