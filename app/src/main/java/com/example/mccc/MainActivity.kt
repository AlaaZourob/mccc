package com.example.mccc

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mccc.R.layout.activity_main
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var db: FirebaseFirestore? = FirebaseFirestore.getInstance()



    override fun onCreate(
            savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("az7", "onCreat :Welcome")
        Log.d("az7", "onCreat :Welcome test")


   savebtn.setOnClickListener {
       saveToFirebase()
   }
        button.setOnClickListener {
            getFromFirebase()
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

        }
    }

    fun saveToFirebase() {
        val username = txtName.text.toString()
        val userNum = txtNum.text.toString()
        val userAddress = txtAddress.text.toString()
        val info: MutableMap<String, Any> = HashMap()
        info["User Name"] = username
        info["User Num"] = userNum
        info["User Address"] = userAddress

        db!!.collection("information")
            .add(info)
            .addOnFailureListener {
                Log.e("az7", "failed")
            }
            .addOnSuccessListener {
                Log.e("az7", "successed")

            }

    }
    @SuppressLint("SetTextI18n")
    var userList = mutableListOf<user>()

    fun getFromFirebase() {
        db!!.collection("information")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        for (document in task.result!!) {
                            val id : String = document.id
                            val data = document.data
                            val userNamme = data["User Name"] as String?
                            val userNumber = data["User Num"] as String?
                            val useraddrees = data["User Address"] as String?
                            userList.add(user(id , userNamme ,userNumber,useraddrees ))
                            Log.d("TAG", document.id + " => " + document.data)
                        }
                    } else {
                        Log.w("TAG", "Error getting documents.", task.exception)
                    }
                }
    }
}