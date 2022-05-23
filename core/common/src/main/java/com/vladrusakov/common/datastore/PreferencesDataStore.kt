package com.vladrusakov.common.datastore

import kotlinx.coroutines.flow.Flow

interface PreferencesDataStore {

    suspend fun save(key: String, value: String)
    suspend fun save(key: String, value: Int)
    suspend fun save(key: String, value: Boolean)
    suspend fun save(key: String, value: Double)
    suspend fun save(key: String, value: Float)
    suspend fun save(key: String, value: Long)

    suspend fun clear()

    fun fetchString(key: String, defaultValue: String) : Flow<String?>
    fun fetchInt(key: String, defaultValue: Int): Flow<Int?>
    fun fetchBoolean(key: String, defaultValue: Boolean): Flow<Boolean?>
    fun fetchDouble(key: String, defaultValue: Double): Flow<Double?>
    fun fetchFloat(key: String, defaultValue: Float): Flow<Float?>
    fun fetchLong(key: String, defaultValue: Long): Flow<Long?>
}