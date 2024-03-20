package com.app.myproductsapp.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class NetworkModule {
    val client: HttpClient by lazy {
        HttpClient(OkHttp) {
            engine {
                config {
                    // configure client
                }
            }

            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                })
            }

            expectSuccess = true
        }
    }
}

object UrlAndPaths {
    val BASE_URL = "http://192.168.100.45:8090"
}