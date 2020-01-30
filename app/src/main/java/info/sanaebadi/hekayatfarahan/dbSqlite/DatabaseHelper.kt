package info.sanaebadi.hekayatfarahan.dbSqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.room.RoomMasterTable
import info.sanaebadi.hekayatfarahan.model.Game


class DatabaseHelper(
    context: Context?
) : SQLiteOpenHelper(context, DATABASE_NAME, null, 9) {


    companion object {
        const val DATABASE_NAME = "game_db"
        const val TABLE_NAME = "game_table"

        const val GAME_TITLE = "title"
        const val GAME_DESC = "description"
        const val GAME_RATE = "rate"
        const val GAME_PLAYER_COUNT = "playersCount"
        const val GAME_GENRE_NAME = "name"
        const val GAME_IMAGE = "image"
        const val GAME_VIDEO = "video"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE $TABLE_NAME ($GAME_TITLE TEXT, $GAME_DESC TEXT, $GAME_RATE TEXT, $GAME_PLAYER_COUNT INTEGER, $GAME_GENRE_NAME TEXT, $GAME_IMAGE TEXT, $GAME_VIDEO TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertNews(
        title: String?,
        description: String?,
        rate: String?,
        player_count: Int?,
        image: String?,
        video: String?
    ): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(GAME_TITLE, title)
        contentValues.put(GAME_DESC, description)
        contentValues.put(GAME_RATE, rate)
        contentValues.put(GAME_PLAYER_COUNT, player_count)
        contentValues.put(GAME_IMAGE, image)
        contentValues.put(GAME_VIDEO, video)
        val result = db.insert(
            TABLE_NAME,
            null,
            contentValues
        ) //error returns -1 else returns the ID value
        return result != -1L
    }

    @SuppressLint("Recycle")
    fun getAllGames(): List<Game>? {
        val db = this.writableDatabase
        val list: MutableList<Game> = ArrayList()
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        while (cursor.moveToNext()) {
            list.add(
                Game(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(6),
                    cursor.getString(7)
                )
            )
        }
        return list
    }


}