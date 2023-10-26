package belajar.android.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(
    private val numbers : List<Int>
):RecyclerView.Adapter<NumberAdapter.ViewHolder>() {
    // impelemntasi pertama daftarkan layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        )
    }

    //keempat aksi didalam nya
    override fun onBindViewHolder(holder: NumberAdapter.ViewHolder, position: Int) {
        //mengubah data
        //akan meloop sesuai list names
        holder.text.text = numbers[position].toString()
    }

    //ketiga, jumlah yang akan ditampilkan
    override fun getItemCount() = numbers.size

    //kedua, karena sudah manggil layoutnya
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val text = view.findViewById<TextView>(R.id.textView)
    }
}