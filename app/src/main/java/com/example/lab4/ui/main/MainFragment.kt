package com.example.lab4.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab4.ContainsItem
import com.example.lab4.R
import com.example.lab4.adapter.ItemAdapter
import com.example.lab4.model.Item
import kotlinx.android.synthetic.main.main_fragment.*



class MainFragment : Fragment(), ContainsItem {

    override fun itemClick(index:Int) {
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.container,DetailFragment.newInstance(index))
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    fun addMemo(title:String, desc:String){
        viewModel.items.add(Item(title,desc))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this.activity!!).get(MainViewModel::class.java)

        content.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        content.adapter = ItemAdapter(viewModel.items, activity!!.applicationContext,this)
        fab.setOnClickListener {
            card.visibility = View.VISIBLE
            fab.hide();
        }

        content.setOnClickListener {
            card.visibility = View.GONE
            fab.show()
        }

        add.setOnClickListener {
            if (!search.text.isEmpty() && !desc.text.isEmpty()){
                addMemo(search.text.toString(),desc.text.toString())
                search.text.clear()
                desc.text.clear()
                card.visibility = View.GONE
                fab.show()
            }

        }

    }

}
