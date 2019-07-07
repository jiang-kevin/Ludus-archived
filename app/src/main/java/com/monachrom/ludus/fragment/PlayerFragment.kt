package com.monachrom.ludus.fragment

import android.media.AudioAttributes
import android.media.MediaPlayer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.monachrom.ludus.LudusApplication

import com.monachrom.ludus.R
import com.monachrom.ludus.media.MediaPlayerService
import com.monachrom.ludus.media.MediaService
import com.monachrom.ludus.viewmodel.PlayerViewModel
import kotlinx.android.synthetic.main.fragment_player.*

class PlayerFragment : Fragment() {

    companion object {
        fun newInstance() = PlayerFragment()
    }

    private lateinit var viewModel: PlayerViewModel
    val args: PlayerFragmentArgs by navArgs()
    val mediaPlayer: MediaService = MediaPlayerService()

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
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PlayerViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
