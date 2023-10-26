package belajar.android.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        modelAdapter()
//        textAdapter()
//        numberAdapter()
//        imageAdapter()
    }

    private fun modelAdapter(){
        val movies = listOf<MovieModel>(
            MovieModel(1, R.drawable.foto1,"ahmad",),
            MovieModel(2, R.drawable.foto2,"ihsan",),
            MovieModel(3, R.drawable.foto3,"rabbani",),
            MovieModel(4, R.drawable.foto4,"ahmad ihsanullah rabbani",)
        )

        val movieAdapter = ModelAdapter(movies, object : ModelAdapter.OnAdapterListener{
            override fun onClick(movie: MovieModel) {
                Toast.makeText(this@MainActivity, movie.name, Toast.LENGTH_SHORT).show()
            }
        })
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }
    }
    private fun imageAdapter(){
        val images = listOf<Int>(
            R.drawable.foto1,
            R.drawable.foto2,
            R.drawable.foto3,
            R.drawable.foto4
        )

        val imageAdapter = ImageAdapter(images)
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = GridLayoutManager(this@MainActivity,3)
            adapter = imageAdapter
        }
    }

    private fun textAdapter(){
        val names = listOf<String>(
            "ahmad", "ihsan","hanif","rehan","iha","ani","asma", "sholihah","ainun"
        )

        val textAdapter = MainAdapter(names, object : MainAdapter.OnAdapterListener{
            override fun onClick(name: String) {
                Toast.makeText(this@MainActivity, name, Toast.LENGTH_SHORT).show()
            }

        })
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            adapter = textAdapter
        }
    }

    private fun numberAdapter(){
        val numbers = listOf(
            1,2,3,4,5,6,7,8,9,10
        )

        val numberAdapter = NumberAdapter(numbers)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = numberAdapter
    }
}