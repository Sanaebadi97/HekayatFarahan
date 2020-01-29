//package info.sanaebadi.hekayatfarahan.db
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import info.sanaebadi.hekayatfarahan.model.Game
//
//@Dao
//interface GameDao {
//
//    @Query("SELECT * FROM game")
//    fun getAllGames(): LiveData<List<Game>>
//
//    @Insert
//    fun insertGame(game: Game)
//}