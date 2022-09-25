package com.example.challenge_chapter4_binar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.challangechapter4.ViewModel.NoteViewModel
import com.example.challenge_chapter4_binar.databinding.FragmentDeleteNoteBinding

class DeleteNoteFragment : Fragment() {
    lateinit var binding : FragmentDeleteNoteBinding
    val viewModel : NoteViewModel by viewModels()
    val args : DeleteNoteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDeleteNoteBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDeleteConfirm.setOnClickListener {
            viewModel.deleteNote(args.datanote.id!!)
            Navigation.findNavController(it!!).navigate(R.id.action_deleteNoteFragment_to_homeFragment)
        }
        binding.btnCancel.setOnClickListener {
            Navigation.findNavController(it!!).navigate(R.id.action_deleteNoteFragment_to_homeFragment)
        }
    }
}