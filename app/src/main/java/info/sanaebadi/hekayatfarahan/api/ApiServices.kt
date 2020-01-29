package info.sanaebadi.hekayatfarahan.api

import info.sanaebadi.hekayatfarahan.model.Game
import retrofit2.http.GET

/**
 * game list api : https://api.myjson.com/bins/pnfbu
 * game details : https://api.myjson.com/bins/1bjyoa
 */
interface ApiServices {

    //game list
    @GET("pnfbu")
    suspend fun getGameList(): List<Game>

    //game details
    @GET("1bjyoa")
    suspend fun getGameDetails(): Game


}