//package info.sanaebadi.hekayatfarahan.db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import info.sanaebadi.hekayatfarahan.model.Game
//
//@Database(entities = [Game::class], version = 1 , exportSchema = false)
//abstract class GameDatabase : RoomDatabase() {
//
//    abstract val gameDao: GameDao
//
//    companion object {
//        private var INSTANCE: GameDatabase? = null
//
//        fun getInstance(context: Context): GameDatabase {
//            synchronized(this) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        GameDatabase::class.java, "game_database"
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                }
//                return INSTANCE!!
//
//            }
//        }
//
//
//    }
//}