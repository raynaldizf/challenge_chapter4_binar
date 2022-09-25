package com.example.challenge_chapter4_binar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.challangechapter4.ViewModel.NoteViewModel
import com.example.challenge_chapter4_binar.databinding.FragmentAddNoteBinding
import com.example.challenge_chapter4_binar.room.DataNote

class AddNoteFragment : Fragment() {
    lateinit var binding : FragmentAddNoteBinding
    val viewModel : NoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnInput.setOnClickListener {
            addNote(it)
        }
    }

    fun addNote(it : View?){

        var judul = binding.etJudul.text.toString()
        var isi = binding.etContent.text.toString()

        val data = DataNote(null, judul, isi)
        viewModel.addNote(data)

        Toast.makeText(context, "Berhasil", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_addNoteFragment_to_homeFragment)
    }

}