package com.riztech.financialtracker.presentation.generaladapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.riztech.financialtracker.R
import com.riztech.financialtracker.domain.model.Movie

class MovieAdapter(private val movies: List<Movie>, private val onClickMovie: (Movie) -> Unit): RecyclerView.Adapter<MovieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_card_item, parent, false))
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bindMovie(movie = movies[position], onClickMovie)
    }

    override fun getItemCount(): Int = movies.size
}

class MovieHolder(view: View): RecyclerView.ViewHolder(view){
    private val poster: AppCompatImageView = view.findViewById(R.id.iv_poster)
    private val title: AppCompatTextView = view.findViewById(R.id.tv_title)
    private val ratingBar: RatingBar = view.findViewById(R.id.rating)

    fun bindMovie(movie: Movie, onClickMovie: (Movie) -> Unit){
        poster.load(movie.poster)
        title.text = movie.title
        ratingBar.rating = movie.rating.toFloat()
        itemView.setOnClickListener {
            onClickMovie.invoke(movie)
        }
    }
}