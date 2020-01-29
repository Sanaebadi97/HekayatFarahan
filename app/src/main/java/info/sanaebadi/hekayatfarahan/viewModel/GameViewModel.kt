package info.sanaebadi.hekayatfarahan.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import info.sanaebadi.hekayatfarahan.model.Game
import info.sanaebadi.hekayatfarahan.repository.Repository

class GameViewModel : ViewModel() {
    val gemes: LiveData<List<Game>> = Repository.getGames()


    fun cancelJob() {
        Repository.cancelJob()
    }

}