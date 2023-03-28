package com.example.picturesdemoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import com.example.picturesdemoapp.screens.home.HomeScreen

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
            //TODO - SearchScreen(navController = navController)
        }
    }
}