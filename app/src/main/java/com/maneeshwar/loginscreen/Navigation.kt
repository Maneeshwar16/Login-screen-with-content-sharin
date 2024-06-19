package com.maneeshwar.loginscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun navigaton() {
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination ="login" ){
        composable("login"){
            loginscreen(navController)
        }
        composable("screen2/{name}",
            arguments = listOf(
                navArgument("name"){type= NavType.StringType}
            )
        ){backStackEntry->
            val name=backStackEntry.arguments?.getString("name")?:""
            screen2(name, navController)

        }
    }

}