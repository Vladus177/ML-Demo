package com.vladrusakov.mldemo.presentation.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.vladrusakov.mldemo.domain.model.StateModel
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class State(
    val id: String,
    val name: String
) : Parcelable

fun StateModel.toUiModel(): State = State(
    id = id,
    name = name
)
