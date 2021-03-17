package com.example.mccc

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user.view.*

class adapter (var activity: Activity, var data: MutableList<user>) :
    RecyclerView.Adapter<adapter.MyViweHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViweHolder {
        val view = LayoutInflater.from(activity).inflate(R.layout.user, parent, false)
        val myHolder = MyViweHolder(view)
        return myHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViweHolder, position: Int) {
        val username = data[position].userName
        val usernum = data[position].userNum
        val userAddress = data[position].userAddress
        holder.userName.text = username
        holder.userNum.text = usernum
        holder.userAddress.text = userAddress

    }

    class MyViweHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userName = itemView.txtname
        val userNum = itemView.txtphone
        val userAddress = itemView.txtaddress

    }
}
