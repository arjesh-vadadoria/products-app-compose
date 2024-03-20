package com.app.myproductsapp.utils

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> String.toArrayListOf(): ArrayList<T> {
    return Gson().fromJson(this, object : TypeToken<ArrayList<T>>() {}.type)
}

inline fun <reified T> String.toMutableStateListOf(): SnapshotStateList<T> {
    return Gson().fromJson(this, object : TypeToken<SnapshotStateList<T>>() {}.type)
}