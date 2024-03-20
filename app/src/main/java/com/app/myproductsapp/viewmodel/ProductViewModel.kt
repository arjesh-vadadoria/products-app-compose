package com.app.myproductsapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.myproductsapp.data.model.Product
import com.app.myproductsapp.network.NetworkModule
import com.app.myproductsapp.network.UrlAndPaths
import com.app.myproductsapp.utils.toMutableStateListOf
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    var productListLiveData = mutableStateListOf<Product>()

    fun getProductList() {
        viewModelScope.launch {
            val response: HttpResponse = NetworkModule().client.get("${UrlAndPaths.BASE_URL}/products")
            if (response.status == HttpStatusCode.OK) {
                val products = response.bodyAsText().toMutableStateListOf<Product>()
                productListLiveData.clear()
                productListLiveData.addAll(products)
            }
        }
    }

}