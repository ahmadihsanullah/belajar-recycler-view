package belajar.android.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ModelAdapter(
    private val listMovie : List<MovieModel>,
    private val listener : OnAdapterListener
):RecyclerView.Adapter<ModelAdapter.ViewHolder>() {
    // impelemntasi pertama daftarkan layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_model, parent, false)
        )
    }

    //keempat aksi didalam nya
    override fun onBindViewHolder(holder: ModelAdapter.ViewHolder, position: Int) {
        //mengubah data
        //akan meloop sesuai list names
        val movie = listMovie[position]
        holder.image.setImageResource(movie.image)
        holder.text.text = movie.name
        holder.itemView.setOnClickListener{
            listener.onClick(movie)
        }
    }

    //ketiga, jumlah yang akan ditampilkan
    override fun getItemCount() = listMovie.size

    //kedua, karena sudah manggil layoutnya
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
        val text = view.findViewById<TextView>(R.id.textView)
    }
    interface OnAdapterListener{
        fun onClick(movie: MovieModel)
    }
}