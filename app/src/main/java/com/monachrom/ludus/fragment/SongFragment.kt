package com.monachrom.ludus.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.monachrom.ludus.R
import com.monachrom.ludus.adapter.SongAdapter
import com.monachrom.ludus.viewmodel.LudusViewModelFactory
import com.monachrom.ludus.viewmodel.SongViewModel
import kotlinx.android.synthetic.main.fragment_song.*
import javax.inject.Inject

class SongFragment : Fragment() {

    companion object {
        fun newInstance() = SongFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: SongViewModel by viewModels(
        factoryProducer = { factory }
    )

    private val viewAdapter = SongAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.songs.observe(viewLifecycleOwner, Observer { songs ->
            viewAdapter.setSongs(songs)
        })

        list_song.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = viewAdapter
        }
    }
}
