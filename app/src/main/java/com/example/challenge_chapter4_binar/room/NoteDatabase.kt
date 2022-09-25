package com.example.challangechapter4.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.challenge_chapter4_binar.room.DataNote


@Database(entities = [DataNote::class], version = 1)
abstract class NoteDatabase : RoomDatabase(){
    abstract fun noteDao() : NoteDAO

    companion object{
        @Volatile
        private var INSTANCE : NoteDatabase? = null

        fun getInstance(context : Context):NoteDatabase? {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this)
            {
                val roomDatabaseInstance =
                    Room.databaseBuilder(
                        context,
                        NoteDatabase::class.java,
                        "note").allowMainThreadQueries().build()
                INSTANCE = roomDatabaseInstance
                return roomDatabaseInstance
            }

        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }

}