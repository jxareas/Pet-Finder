package com.jxareas.petfinder.petsnearby.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jxareas.petfinder.R

class PetsNearbyFragment : Fragment() {

    companion object {
        fun newInstance() = PetsNearbyFragment()
    }

    private lateinit var viewModel: PetsNearbyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pets_nearby, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PetsNearbyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
