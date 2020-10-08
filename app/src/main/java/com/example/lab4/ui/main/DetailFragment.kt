package com.example.lab4.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.lab4.R
import com.example.lab4.model.Item
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment(var index: Int) : Fragment() {

    companion object {
        fun newInstance(index:Int) = DetailFragment(index)
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this.activity!!).get(MainViewModel::class.java)
        val item: Item = viewModel.items.get(index)
        title.text = item.title.toString()
        description.text = item.desc
        toolbar.setNavigationOnClickListener {
            this.activity!!.onBackPressed()
        }
    }

}
