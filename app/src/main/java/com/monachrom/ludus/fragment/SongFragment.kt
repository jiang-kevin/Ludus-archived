package com.monachrom.ludus.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.monachrom.ludus.R
import com.monachrom.ludus.util.InjectorUtils
import com.monachrom.ludus.viewmodel.SongViewModel

class SongFragment : Fragment() {

    companion object {
        fun newInstance() = SongFragment()
    }

    private lateinit var viewModel: SongViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_song, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = InjectorUtils.provideSongViewModelFactory()

        viewModel = ViewModelProviders.of(this, factory).get(SongViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
