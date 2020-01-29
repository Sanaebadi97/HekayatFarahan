package info.sanaebadi.hekayatfarahan.view.fragment


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import info.sanaebadi.hekayatfarahan.R
import info.sanaebadi.hekayatfarahan.dbSqlite.DatabaseHelper
import info.sanaebadi.hekayatfarahan.view.adapter.GameAdapter
import info.sanaebadi.hekayatfarahan.viewModel.GameViewModel
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 */
class GameListHome : Fragment() {

    lateinit var gameAdapter: GameAdapter

    private val viewModel: GameViewModel by viewModel()

    private lateinit var databaseHelper: DatabaseHelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game_list_home, container, false)
        val rvGameList = view.findViewById<RecyclerView>(R.id.rv_game)
        val progressbar = view.findViewById<ProgressBar>(R.id.progressbar)


        databaseHelper = DatabaseHelper(activity!!)



        progressbar.visibility = View.VISIBLE


        if (hasNetwork(activity!!)!!) {

            viewModel.gemes.observe(viewLifecycleOwner, Observer { games ->

                gameAdapter = GameAdapter(games)
                rvGameList.setHasFixedSize(true)
                rvGameList.layoutManager =
                    GridLayoutManager(activity, 2) as RecyclerView.LayoutManager?
                rvGameList.adapter = gameAdapter
                progressbar.visibility = View.GONE


                for (i in games.indices) {
                    println("game is ${games[i].rate} , ${games[i].title}")
                    val inserted: Boolean = databaseHelper.insertNews(
                        games[i].title,
                        games[i].description,
                        games[i].rate,
                        games[i].players_count,
                        games[i].genre.name,
                        games[i].image,
                        games[i].video
                    )


                    if (inserted) {
                        println("INSERTED")
                    } else {
                        println("NOT INSERTED")

                    }
                }



            })
        } else {
            Toast.makeText(activity!!, getString(R.string.no_internet), Toast.LENGTH_SHORT).show()


        }

        return view
    }


    fun hasNetwork(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }


}
