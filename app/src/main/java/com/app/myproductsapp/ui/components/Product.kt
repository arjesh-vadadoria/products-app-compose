package com.app.myproductsapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.myproductsapp.data.model.Product
import com.app.myproductsapp.ui.theme.Black
import com.app.myproductsapp.ui.theme.Gray
import com.app.myproductsapp.ui.theme.defaultCardBorder

@Composable
fun ProductList(modifier: Modifier = Modifier, productList: SnapshotStateList<Product>) {
    LazyColumn(modifier) {
        items(productList) { item ->
            Product(item)
        }
    }
}

@Composable
fun Product(item: Product) {
    Card(
        modifier = Modifier
            .padding(vertical = 8.dp),
        border = defaultCardBorder,
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            text = item.name,
            fontSize = 14.sp,
            color = Black,
            modifier = Modifier.padding(
                top = 5.dp,
                end = 5.dp,
                start = 5.dp
            ),
        )
        Text(
            text = item.description,
            lineHeight = 13.sp,
            fontSize = 12.sp,
            color = Gray,
            modifier = Modifier.padding(
                bottom = 5.dp,
                end = 5.dp,
                start = 5.dp
            )
        )
    }
}