package com.example.picturesdemoapp.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.picturesdemoapp.navigation.Screen
import com.example.picturesdemoapp.ui.common.ListContent

@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val getAllImages = homeViewModel
        .getAllImages
        .collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar {
                navController.navigate(Screen.Search.route)
            }
        },
        content = { paddingValues ->
            ListContent(
                items = getAllImages,
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}


