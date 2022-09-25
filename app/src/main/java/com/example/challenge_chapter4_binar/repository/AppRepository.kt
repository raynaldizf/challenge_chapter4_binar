package com.example.challangechapter4.Repository

import androidx.lifecycle.LiveData
import com.example.challangechapter4.room.NoteDAO
import com.example.challenge_chapter4_binar.room.DataNote

class AppRepository(val dao : NoteDAO) {


    fun getAllNote(): LiveData<List<DataNote>>{
        return dao.getDataNote()
    }
    fun insertNote(note : DataNote){
        dao.insertNote(note)
    }
    fun deleteNote(id : Int){
        dao.deleteNote(id)
    }
    fun updateNote(note : DataNote){
        dao.updateNote(note)
    }



}