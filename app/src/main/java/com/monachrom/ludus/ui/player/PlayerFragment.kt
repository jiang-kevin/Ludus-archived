package com.monachrom.ludus.ui.player

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.monachrom.ludus.R
import com.monachrom.ludus.service.MediaPlayerService
import com.monachrom.ludus.service.MediaService
import kotlinx.android.synthetic.main.fragment_player.*

class PlayerFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerFragment()
    }

    private lateinit var viewModel: PlayerViewModel
    private val args: PlayerFragmentArgs by navArgs()
    private val mediaPlayer: MediaService = MediaPlayerService()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_play.setOnClickListener {
            mediaPlayer.playSong(args.songUri)
        }

        button_pause.setOnClickListener {
            mediaPlayer.pauseSong()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlayerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
