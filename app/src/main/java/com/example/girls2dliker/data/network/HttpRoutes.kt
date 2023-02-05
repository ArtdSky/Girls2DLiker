package com.example.girls2dliker.data.network

object HttpRoutes {
    private const val BASE_URL = "https://api.waifu.im/search/"
    const val INCLUDED_TAGS = "included_tags=waifu"
    const val EXCLIDED_TAGS = ""
    const val EXCLUDED_FILES = ""
    const val IS_NSFW = "is_nsfw=false"
    const val GIF = "gif=false"
    const val MANY = "many=true"
    const val MARVEL = "https://gateway.marvel.com/v1/public/characters?apikey=636b95b454454878fad55656c78b3ec0&hash=9b2ebe44572b4c206a6bb5f379f10729&ts=1"


    const val TEST = "$BASE_URL?$MANY&$GIF&$IS_NSFW"
}