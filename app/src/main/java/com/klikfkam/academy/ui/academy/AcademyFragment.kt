package com.klikfkam.academy.ui.academy


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.klikfkam.academy.R
import com.klikfkam.academy.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_academy.*

class AcademyFragment : Fragment() {


    private lateinit var academyAdapter: AcademyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_academy, container, false)
    }

    companion object{
        fun newInstance(): Fragment {
            return AcademyFragment()
        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        academyAdapter = context?.let { AcademyAdapter(it, DataDummy.generateDummyCourses()) }!!
        if (activity != null) {
            rv_academy.layoutManager = LinearLayoutManager(context)
            rv_academy.setHasFixedSize(true)
            rv_academy.adapter = academyAdapter

        }
    }


}
