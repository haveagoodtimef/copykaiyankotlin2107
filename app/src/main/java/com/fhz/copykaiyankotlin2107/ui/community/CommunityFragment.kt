package com.fhz.copykaiyankotlin2107.ui.community

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fhz.copykaiyankotlin2107.R

class CommunityFragment : Fragment() {

    companion object {
        fun newInstance() = CommunityFragment()
    }

    private lateinit var viewModel: CommunityViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment_community, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CommunityViewModel::class.java)
        // TODO: Use the ViewModel
    }

}