package info.sanaebadi.hekayatfarahan.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import info.sanaebadi.hekayatfarahan.model.Game
import info.sanaebadi.hekayatfarahan.repository.Repository

class GameDetailsViewModel : ViewModel() {

    val gameDetails: LiveData<Game> = Repository.getGameDetails()

    fun cancelJob() {
        Repository.cancelJob()
    }

}