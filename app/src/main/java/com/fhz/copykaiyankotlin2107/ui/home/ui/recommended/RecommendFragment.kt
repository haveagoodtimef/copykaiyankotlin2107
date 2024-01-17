package com.fhz.copykaiyankotlin2107.ui.home.ui.recommended

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fhz.copykaiyankotlin2107.R

class RecommendFragment : Fragment() {

    companion object {
        fun newInstance() = RecommendFragment()
    }

    private lateinit var viewModel: RecommendViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment_recommend, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecommendViewModel::class.java)
        // TODO: Use the ViewModel
    }

}