package com.alexbazlinton.topmovieslist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class FavouritesActivity extends AppCompatActivity {

    TextView favourites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        String favouriteMovies = sharedPref.getString("MyFavourite", new ArrayList<Movie>().toString());
        Log.d("Favourite movie:", favouriteMovies);

        Gson gson = new Gson();
        TypeToken<ArrayList<Movie>> movieArrayListToken = new TypeToken<ArrayList<Movie>>(){};
        ArrayList<Movie> myFavourites = gson.fromJson(favouriteMovies, movieArrayListToken.getType());

        Intent intent = getIntent();
        Movie selectedMovie = (Movie) intent.getSerializableExtra("movie");

        myFavourites.add(selectedMovie);

        String movieString = "";
        for(Movie movie : myFavourites){
            movieString += movie.getTitle() + "-" + movie.getYear() + "\n";
        }

        favourites = findViewById(R.id.favourites);
        favourites.setText(movieString);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("MyFavourite", gson.toJson(myFavourites));
        editor.apply();

        Toast.makeText(this, selectedMovie.getTitle() + " is added!", Toast.LENGTH_LONG).show();
    }
}
