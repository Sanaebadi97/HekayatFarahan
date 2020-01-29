package info.sanaebadi.hekayatfarahan.model


data class Game(
    val title: String,
    val description: String,
    val rate: String,
    val players_count: Int,
    val genre: Genre,
    val image: String,
    val video: String
)