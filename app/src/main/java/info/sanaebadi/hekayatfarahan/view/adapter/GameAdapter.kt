package info.sanaebadi.hekayatfarahan.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import info.sanaebadi.hekayatfarahan.R
import info.sanaebadi.hekayatfarahan.model.Game
import kotlinx.android.synthetic.main.game_item_list.view.*

private var navController: NavController? = null

class GameAdapter(var gemeList: List<Game>) :
    RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtGameTitle: AppCompatTextView = itemView.txt_game_title
        val txtGameDesc: AppCompatTextView = itemView.txt_game_desc
        val txtGameRate: AppCompatTextView = itemView.txt_game_rate
        val imgGame: AppCompatImageView = itemView.img_game
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.game_item_list, parent, false)
        return GameViewHolder(view)
    }

    override fun getItemCount() = gemeList.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = this.gemeList[position]
        holder.txtGameDesc.text = game.description
        holder.txtGameTitle.text = game.title
        holder.txtGameRate.text = game.rate

        Glide.with(holder.itemView.context).load(game.image).into(holder.imgGame)
        holder.itemView.setOnClickListener {
            //listener.onItemClick(it)
            navController = Navigation.findNavController(it)

            val bundle = bundleOf(
                "gameImage" to game.image,
                "gameTitle" to game.title,
                "gameDesc" to game.description,
                "playerCount" to game.players_count,
                "gameVideo" to game.video,
                "genreName" to game.genre.name,
                "genreImage" to game.genre.image


            )

            navController!!.navigate(R.id.action_gameListHome_to_gameDetailsFragment, bundle)


        }
    }



}