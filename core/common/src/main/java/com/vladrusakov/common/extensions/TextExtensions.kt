package com.vladrusakov.common.extensions

import com.vladrusakov.common.CommonConstants.AMOUNT_PATTERN
import com.vladrusakov.common.CommonConstants.NOT_AVAILABLE
import com.vladrusakov.common.CommonConstants.OFF
import com.vladrusakov.common.CommonConstants.SIGN
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*
import kotlin.math.roundToInt

fun String.formatSearchQuery(): String {
    return this.replace(" ", "%20")
}

fun Double.validateAndConvertToString(): String {
    return if (this >= 0.0) this.toString() else NOT_AVAILABLE
}

fun Int.validateAndConvertToString(): String {
    return if (this >= 0) this.toString() else NOT_AVAILABLE
}

fun Long.validateAndConvertToString(): String {
    return if (this >= 0) this.toString() else NOT_AVAILABLE
}

fun Double.formatPrice(): String {
    val nf = NumberFormat.getNumberInstance(Locale.GERMAN)
    val formatter = nf as DecimalFormat
    formatter.applyPattern(AMOUNT_PATTERN)
    return SIGN + formatter.format(this)
}

fun Double.formatDiscount(originalPrice: Double): String {
    if (originalPrice <= 0.0) return ""
    val diff = (originalPrice - this) / this * 100
    return "${diff.roundToInt()}$OFF"
}

fun String.formatInstallments(installmensAmount: String): String {
    return "en $this x $ $installmensAmount sin interes"
}