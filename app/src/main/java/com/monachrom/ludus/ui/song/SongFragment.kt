package com.monachrom.ludus.ui.song

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.monachrom.ludus.R
import com.monachrom.ludus.di.Injector
import kotlinx.android.synthetic.main.fragment_song.*
import javax.inject.Inject

class SongFragment : Fragment() {

    companion object {
        fun newInstance() = SongFragment()
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: SongViewModel by lazy {
        ViewModelProviders.of(this, factory)[SongViewModel::class.java]
    }

    private val viewAdapter = SongAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        factory = Injector.get().viewModelFactory()
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
