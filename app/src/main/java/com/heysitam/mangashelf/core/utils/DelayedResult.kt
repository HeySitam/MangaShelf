package com.heysitam.mangashelf.core.utils

import java.lang.Exception

data class DelayedResult<T>(
    private val value: T? = null,
    private val error: Exception? = null,
    private val isInProgress: Boolean = false
) {
    companion object {
        fun <T> fromError(e: Exception) = DelayedResult<T>(error = e)
        fun <T> fromValue(result: T) = DelayedResult(value = result)
        fun <T> inProgress() = DelayedResult<T>(isInProgress = true)
        fun <T> idle() = DelayedResult<T>()
    }

    val successValue: T? get() = value

    val isSuccessful: Boolean get() = value != null
    val isError: Boolean get() = error != null
    val isIdle: Boolean get() = value == null && error == null && !isInProgress
    val isLoading: Boolean get() = isInProgress
}


