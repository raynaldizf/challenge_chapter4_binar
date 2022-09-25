package com.example.challenge_chapter4_binar

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challangechapter4.ViewModel.NoteViewModel
import com.example.challenge_chapter4_binar.adapter.NoteAdapter
import com.example.challenge_chapter4_binar.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var sharedPref : SharedPreferences
    val viewModel : NoteViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        viewModel.getNote().observe(viewLifecycleOwner,{ listNote ->

            binding.rvNote.layoutManager = LinearLayoutManager(requireContext())
            binding.rvNote.adapter = NoteAdapter(requireContext(),listNote)

        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = requireActivity().getSharedPreferences("datauser",Context.MODE_PRIVATE)
        var getData = sharedPref.getString("username","")
        binding.homeUsername.text = "Welcome, $getData"

        binding.btnLogout.setOnClickListener{
            var session =  sharedPref.edit()
            session.clear()
            session.apply()
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_loginFragment)
        }

        binding.floatingActionButton.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_addNoteFragment)
        }
    }
}