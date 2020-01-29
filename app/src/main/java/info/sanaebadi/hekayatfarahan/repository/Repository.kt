package info.sanaebadi.hekayatfarahan.repository

import androidx.lifecycle.LiveData
import info.sanaebadi.hekayatfarahan.api.ApiClient
import info.sanaebadi.hekayatfarahan.api.ApiServices
import info.sanaebadi.hekayatfarahan.model.Game
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object Repository {

    var job: CompletableJob? = null

    //game list
    fun getGames(): LiveData<List<Game>> {
        job = Job()

        return object : LiveData<List<Game>>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(IO + theJob).launch {
                        //fetch data from web service here
                        val games = ApiClient.createWebAPI<ApiServices>().getGameList()
                        withContext(Main) {
                            value = games
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }


    //game details
    fun getGameDetails(): LiveData<Game>{
        job = Job()

        return object : LiveData<Game>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(IO + theJob).launch {
                        //fetch data from web service here
                        val gameDetails = ApiClient.createWebAPI<ApiServices>().getGameDetails()
                        withContext(Main) {
                            value = gameDetails
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }

    //cancel the job
    fun cancelJob() {
        job?.cancel()
    }
}