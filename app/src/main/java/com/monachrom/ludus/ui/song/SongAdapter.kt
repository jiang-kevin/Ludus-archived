package com.monachrom.ludus.ui.song

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.monachrom.ludus.R
import com.monachrom.ludus.model.Song
import kotlinx.android.synthetic.main.item_song.view.*

class SongAdapter(): RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    private var songs = emptyList<Song>()

    class SongViewHolder(val songView: View) : RecyclerView.ViewHolder(songView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val songView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_song, parent, false)

        return SongViewHolder(songView)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.songView.title.text = song.name
        holder.songView.subtext1.text = song.album
        holder.songView.subtext2.text = song.artist
        holder.songView.subtext3.text = song.albumArtist

        holder.songView.setOnClickListener {
            val action = SongFragmentDirections.playSong(song.uri)
            it.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    fun setSongs(newSongs: List<Song>) {
        songs = newSongs
        notifyDataSetChanged()
    }
}