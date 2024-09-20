package com.example.apiintergration

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    //this is used to define adapter and view..
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //define recyclerView
        recyclerView=findViewById(R.id.recycerView)


        val retrofitBuilder=Retrofit.Builder()
            .baseUrl("https://dummyapi.online/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        //Here I am apply get data through api
        val retrofitData=retrofitBuilder.getProductData()
        retrofitData.enqueue(object : Callback<MobileData?> {
            override fun onResponse(p0: Call<MobileData?>, p1: Response<MobileData?>) {
                //agar api success fully call ho jato hai to data ko app me show karana hai
                val responseBody=p1.body()
                val productList=responseBody

                //that is basically declare adapter
                adapter=Adapter(this@MainActivity,productList!!)
                recyclerView.adapter=adapter
                recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)


                //when only api show on text view.
//                val collectDataInSb=StringBuilder()
//                for(myData in productList!!){
//
//                    collectDataInSb.append(myData.brand + " ")
//                }
//                val tv=findViewById<TextView>(R.id.TextView1)
//                tv.text=collectDataInSb
            }

            override fun onFailure(p0: Call<MobileData?>, p1: Throwable) {
            //if api is fail then
                Log.d("Main Activity","OnFailure"+p1.message)
            }
        })
    }
}