package com.example.myhometablet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myhometablet.databinding.RechargeListItemBinding

class RechargeRecyclerViewAdapter(private val recharges : List<Mobile_recharge>,
                                  private val onCardClicked : (Mobile_recharge)->Unit
                                  ) : RecyclerView.Adapter<MyViewHodler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHodler {
        val inflater = LayoutInflater.from(parent.context)
        val binding : RechargeListItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.recharge_list_item, parent, false)
        return MyViewHodler(binding)
    }

    override fun onBindViewHolder(holder: MyViewHodler, position: Int) {
        holder.bindRecharge(recharges[position], onCardClicked)
    }

    override fun getItemCount(): Int {
        return recharges.size
    }
}

class MyViewHodler(val binding: RechargeListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindRecharge(mobileRecharge: Mobile_recharge, onCardClicked: (Mobile_recharge) -> Unit)
    {
        binding.MobileNumberTextView.text = mobileRecharge.mobileNumber
        binding.AmountTextView.text = mobileRecharge.amount.toString()
        binding.PaidByTextView.text = mobileRecharge.paidBy
        binding.rechargeCardView.setOnClickListener{ onCardClicked(mobileRecharge) }
    }
}