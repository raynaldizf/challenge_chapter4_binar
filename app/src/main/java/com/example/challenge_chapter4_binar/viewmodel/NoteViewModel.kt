package com.example.challangechapter4.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.challangechapter4.Repository.AppRepository
import com.example.challangechapter4.room.NoteDatabase
import com.example.challenge_chapter4_binar.room.DataNote

class NoteViewModel(application : Application) : AndroidViewModel(application) {

    val repository : AppRepository

    init {
        val dao = NoteDatabase.getInstance(application)!!.noteDao()
        repository = AppRepository(dao)
    }

    fun addNote(note : DataNote){
        repository.insertNote(note)
    }
    fun getNote():LiveData<List<DataNote>> = repository.getAllNote()

    fun deleteNote(id : Int){
        repository.deleteNote(id)
    }
    fun updateNote(note : DataNote){
        repository.updateNote(note)
    }
}