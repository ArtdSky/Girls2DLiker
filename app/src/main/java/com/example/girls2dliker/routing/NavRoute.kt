package com.example.girls2dliker.routing

sealed class NavRoute(val route: String) {

    object Check: NavRoute("check")

    object Favorites: NavRoute("favorites")

    object Image : NavRoute("image"){
        val url = "url"
    }

}