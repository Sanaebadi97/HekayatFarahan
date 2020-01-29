//package info.sanaebadi.hekayatfarahan.db
//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.LiveData
//import info.sanaebadi.hekayatfarahan.model.Game
//
//class ViewModel constructor(application: Application) : AndroidViewModel(application) {
//
//
//    private val gameRepository: GameRepository = GameRepository(application)
//    private var allGames: LiveData<List<Game>>? = null
//
//    init {
//        allGames = gameRepository.getAllGames()
//    }
//
//
//    fun insert(game: Game) {
//        gameRepository.insert(game)
//    }
//
//
//    fun getAllGames(): LiveData<List<Game>>? {
//        return allGames!!
//    }
//}