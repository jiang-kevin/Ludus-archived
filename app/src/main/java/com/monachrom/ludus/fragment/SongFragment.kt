package com.monachrom.ludus.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.monachrom.ludus.R
import com.monachrom.ludus.adapter.SongAdapter
import com.monachrom.ludus.util.InjectorUtils
import com.monachrom.ludus.viewmodel.SongViewModel
import kotlinx.android.synthetic.main.fragment_song.*

class SongFragment : Fragment() {

    companion object {
        fun newInstance() = SongFragment()
    }

    private lateinit var viewModel: SongViewModel
    private val viewAdapter = SongAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val factory = InjectorUtils.provideSongViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory).get(SongViewModel::class.java)

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
