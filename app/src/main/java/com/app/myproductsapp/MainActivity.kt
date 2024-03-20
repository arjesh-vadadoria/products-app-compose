package com.app.myproductsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.myproductsapp.ui.components.ProductList
import com.app.myproductsapp.ui.theme.MyProductsAppTheme
import com.app.myproductsapp.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mProductViewModel = ProductViewModel()
        mProductViewModel.getProductList()

        setContent {
            MyProductsAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ProductList(
                        Modifier.padding(
                            start = 10.dp,
                            end = 10.dp
                        ),
                        productList = mProductViewModel.productListLiveData
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyProductsAppTheme {
//        ProductList(
//            Modifier.padding(5.dp),
//            mProductViewModel.productListLiveData
//        )
    }
}