package com.example.mccc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*






class MainActivity2 : AppCompatActivity() {
    val aobject = MainActivity()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        myRecyclerView.layoutManager = LinearLayoutManager(this)
        val useradapter = adapter(this, aobject.userList)
        myRecyclerView.adapter=useradapter


    }
}


