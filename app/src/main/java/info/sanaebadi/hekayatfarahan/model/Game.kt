package info.sanaebadi.hekayatfarahan.model


data class Game(
    val title: String,
    val description: String,
    val rate: String,
    val players_count: Int,
    val genre: Genre,
    val image: String,
    val video: String
) {
    constructor(
        title: String?,
        description: String?,
        rate: String?,
        players_count: Int,
        image: String?,
        video: String?
    ) : this(title!!, description!!, rate!!, players_count, Genre(0, "", ""), image!!, video!!)
}