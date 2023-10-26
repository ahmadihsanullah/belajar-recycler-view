package belajar.android.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    private val names : List<String>,
    private val listener: OnAdapterListener
):RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    // impelemntasi pertama daftarkan layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        )
    }

    //keempat aksi didalam nya
    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        //mengubah data
        //akan meloop sesuai list names
        val  name = names[position]
        holder.text.text = name
        holder.container.setOnClickListener{
            Log.e("textadapter", name)
            //menggunakan interface dan akan diaktifkan di activity
            listener.onClick(name)
        }
    }

    //ketiga, jumlah yang akan ditampilkan
    override fun getItemCount() = names.size

    //kedua, karena sudah manggil layoutnya
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val container = view.findViewById<ConstraintLayout>(R.id.container)
        val text = view.findViewById<TextView>(R.id.textView)
    }

    interface OnAdapterListener{
        fun onClick(name:String)
    }
}

