package com.example.myhometablet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhometablet.databinding.FragmentAddRechargeBinding

class AddRecharge : Fragment() {

    private lateinit var binding: FragmentAddRechargeBinding
    private lateinit var rechargeVM : MobileRechargeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_recharge, container, false)
        val mobdao = mobileRechargeDatabase.getInstance(requireContext()).mobileRechargeDAO
        val repository = MobileRechargeRepository(mobdao)
        val factory = MobileRechargeVMFactory(repository)
        rechargeVM = ViewModelProvider(this, factory).get(MobileRechargeViewModel::class.java)
        binding.mobileRechVM = rechargeVM
        binding.lifecycleOwner = this
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView(){
        binding.RechargeListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        printALl()
    }

    private fun printALl(){
        rechargeVM.recharges.observe(viewLifecycleOwner, Observer {
            Log.i("fragment", it.toString())
            binding.RechargeListRecyclerView.adapter = RechargeRecyclerViewAdapter(it)
        })
    }
}