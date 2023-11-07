package com.example.zhest

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var randomButton: Button
    private lateinit var movieTextView: TextView
    private val movies = mutableListOf<String>()
   private var currentIndex = -1
    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        randomButton = findViewById(R.id.randomButton)
        movieTextView = findViewById(R.id.movieTextView)
        resetButton = findViewById(R.id.resetButton)
        movies.addAll(resources.getStringArray(R.array.movies))

        randomButton.setOnClickListener {
            displayRandomMovie()
        }

        resetButton.setOnClickListener {
            resetMovies()
        }
    }
    private fun resetMovies() {
        movies.clear()
        movies.addAll(resources.getStringArray(R.array.movies))
        currentIndex = -1
        movieTextView.text = ""
    }


    private fun displayRandomMovie() {
        if (movies.isEmpty()) {
            movieTextView.text = "Все фильмы просмотрены"
            return
        }

        val randomIndex = (0 until movies.size).random()
        val randomMovie = movies.removeAt(randomIndex)
        currentIndex = randomIndex
        movieTextView.text = randomMovie
    }
}
