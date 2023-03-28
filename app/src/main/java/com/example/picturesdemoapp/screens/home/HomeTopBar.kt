package com.example.picturesdemoapp.screens.home

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    onSearchClicked: () -> Unit
){
    TopAppBar(
        title = { Text(text = "Home", color = MaterialTheme.colorScheme.onBackground) },
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        },
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    HomeTopBar {}
}