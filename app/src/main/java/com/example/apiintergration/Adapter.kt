package com.example.apiintergration

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class Adapter(val context:Activity,val productList: List<MobileDataItem>):RecyclerView.Adapter<Adapter.MyViewHolder>() {

    //that is basically used define the view for our app
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        var tittle:TextView
        var image:ImageView
        var category:TextView
        var price:TextView
        init {
           tittle=itemView.findViewById(R.id.productName)
            image=itemView.findViewById(R.id.productImage)
            category=itemView.findViewById(R.id.productCat)
            price=itemView.findViewById(R.id.productPrice)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.rv_item,parent,false)
        return MyViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return productList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=productList[position]
        holder.tittle.text=currentItem.name
        holder.category.text=currentItem.productCategory
        holder.price.text= currentItem.basePrice.toString()

        //used picasso
        Picasso.get().load(currentItem.thumbnailImage).into(holder.image)
    }
}