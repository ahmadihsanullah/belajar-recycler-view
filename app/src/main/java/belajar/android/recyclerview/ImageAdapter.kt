package belajar.android.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val listImage : List<Int>
):RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    // impelemntasi pertama daftarkan layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_image, parent, false)
        )
    }

    //keempat aksi didalam nya
    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {
        //mengubah data
        //akan meloop sesuai list names
        holder.image.setImageResource(listImage[position])
    }

    //ketiga, jumlah yang akan ditampilkan
    override fun getItemCount() = listImage.size

    //kedua, karena sudah manggil layoutnya
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
    }
}