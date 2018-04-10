package com.alexbazlinton.topmovieslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//    String[] data = {"One", "Two", "Three"};


    ArrayList<Movie> topMovies = new TopMovies().getList();

//    ArrayAdapter<Movie> arrayAdapter = new ArrayAdapter<>(this, R.layout.title, topMovies);

    TopMoviesAdapter moviesAdapter = new TopMoviesAdapter(this, topMovies);

    ListView listView = findViewById(R.id.list_view);
    listView.setAdapter(moviesAdapter);


  }
}
