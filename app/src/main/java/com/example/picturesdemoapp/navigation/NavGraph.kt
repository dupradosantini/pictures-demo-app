package com.example.picturesdemoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import com.example.picturesdemoapp.screens.home.HomeScreen
import com.example.picturesdemoapp.screens.search.SearchScreen

@Composable
@ExperimentalPagingApi
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(route = Screen.Home.route){
            HomeScreen(
                navController = navController
            )
        }
        composable(route = Screen.Search.route){
            SearchScreen(navController = navController)
        }
    }
}