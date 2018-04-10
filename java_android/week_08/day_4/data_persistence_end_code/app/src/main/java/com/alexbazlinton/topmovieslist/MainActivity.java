package com.alexbazlinton.topmovieslist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ArrayList<Movie> topMovies = new TopMovies().getList();

    TopMoviesAdapter moviesAdapter = new TopMoviesAdapter(this, topMovies);

    ListView listView = findViewById(R.id.list_view);
    listView.setAdapter(moviesAdapter);

  }

  public void getMovie(View listItem){
    Movie movie = (Movie) listItem.getTag();
    Log.d(getClass().toString(), movie.getTitle() + " is selected");
    Intent intent = new Intent(this, FavouritesActivity.class);
    intent.putExtra("movie", movie);
    startActivity(intent);
  }

}
