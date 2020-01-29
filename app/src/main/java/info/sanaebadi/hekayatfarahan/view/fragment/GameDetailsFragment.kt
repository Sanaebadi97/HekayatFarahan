package info.sanaebadi.hekayatfarahan.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import info.sanaebadi.hekayatfarahan.R
import info.sanaebadi.hekayatfarahan.viewModel.GameDetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 */
class GameDetailsFragment : Fragment() {

    private val viewModel: GameDetailsViewModel by viewModel()

    private var gameImage: String? = null
    private var gameTitle: String? = null
    private var gameDesc: String? = null
    private var playerCount: Int? = null
    private var gameVideo: String? = null
    private var genreName: String? = null
    private var genreImage: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gameImage = arguments!!.getString("gameImage")
        gameTitle = arguments!!.getString("gameTitle")
        gameDesc = arguments!!.getString("gameDesc")
        playerCount = arguments!!.getInt("playerCount")
        gameVideo = arguments!!.getString("gameVideo")
        genreImage = arguments!!.getString("genreImage")
        genreName = arguments!!.getString("genreName")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_game_detials, container, false)
        val imgGame = view.findViewById<AppCompatImageView>(R.id.img_game)
        val txtGameTitle = view.findViewById<AppCompatTextView>(R.id.txt_game_title)
        val txtGameDesc = view.findViewById<AppCompatTextView>(R.id.txt_game_desc)
        val txtPlayerCount = view.findViewById<AppCompatTextView>(R.id.txt_player_count)
        val txtGenre = view.findViewById<AppCompatTextView>(R.id.txt_genre)
        val imgGenre = view.findViewById<AppCompatImageView>(R.id.img_genre)
        val txtVideo = view.findViewById<AppCompatTextView>(R.id.txt_video)

        viewModel.gameDetails.observe(viewLifecycleOwner, Observer { gameDetails ->
            println("GAMES $gameDetails")

        })



        Glide.with(activity!!).load(gameImage).into(imgGame)


        Glide.with(activity!!).load(genreImage)
            .apply(RequestOptions.circleCropTransform())
            .into(imgGenre)

        txtGameTitle.text = gameTitle
        txtGameDesc.text = gameDesc
        txtPlayerCount.text = playerCount.toString()
        txtGenre.text = genreName
        txtVideo.text = gameVideo

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJob()
    }

}
