package com.example.girls2dliker.routing

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface AppDistination {
    val route : String
}

object Check : AppDistination{
    override val route = "check"
}
object Favorites : AppDistination{
    override val route = "favorites"
}
object Image : AppDistination{
    override val route = "image"
}
object SingleImage : AppDistination{
    override val route = "singleImage"

    const val urlTypeArg = "account_type"
    val arguments = listOf(
        navArgument(urlTypeArg) { type = NavType.StringType }
    )
    val routeWithArgs = "${route}/{${urlTypeArg}}"

}

val AppTabRowScreens = listOf(Check, Favorites)