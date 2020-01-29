//package info.sanaebadi.hekayatfarahan.db
//
//import android.app.Application
//import android.os.AsyncTask
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import info.sanaebadi.hekayatfarahan.model.Game
//
//class GameRepository constructor(application: Application) : AndroidViewModel(application) {
//
//    private var gameDao: GameDao? = null
//    private var allGames: LiveData<List<Game>>? = null
//
//    init {
//        val database = GameDatabase.getInstance(application)
//        gameDao = database.gameDao
//        allGames = gameDao!!.getAllGames()
//
//
//    }
//
//
//    fun insert(game: Game) {
//        InsertAsync(gameDao!!).execute(game)
//
//    }
//
//    fun getAllGames(): LiveData<List<Game>> {
//        return allGames!!
//    }
//
//    companion object {
//
//        class InsertAsync(private val gameDao: GameDao) : AsyncTask<Game, Boolean, Boolean>() {
//
//            override fun doInBackground(vararg params: Game?): Boolean {
//                gameDao.insertGame(params[0]!!)
//                return true
//            }
//
//        }
//    }
//}