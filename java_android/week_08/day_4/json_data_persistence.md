# Saving JSON to SharedPreferences

## Learning Objectives

  - Know what data persistence options there are in Android
  - Understand serialization and deserialization
  - Be able to store JSON in SharedPreferences
  - Be able to implement a Toast

### Introduction

Android offers us several options for data persistence. The method that you choose depends on your specific needs, such as whether the data should be private to your application or accessible to other applications (and the user) and how much space your data requires.

The methods are:

* Shared Preferences - store private primitive data in key-value pairs.

* Internal Storage - store private data on the device memory.

* External Storage - store public data on the shared external storage e.g. SD card .

* SQLite Databases - store structured data in a private database.

* Network Connection - store data on the web with your own network server.

We're going to use SharedPreferences which is a simple store of key/value pairs, a bit like a hash.

Often, you'll just want to store simple key/value pairs such as user IDs or session variables. But it's also possible to store JSON in SharedPreferences which gives us a way of storing complex data structures including ArrayLists for example. We

### Why Are We Doing This?

We're doing this because becoming familiar with JSON is a very useful skill to have as a programmer, and not just in the world of Java/Android. Also, it could be very useful when it comes to building an app for your project.

### I Do

Let's build on our TopMoviesList. So far we are passing a Movie object through to the getMovie method and logging out the title of the movie.

> Draw a diagram of the relationship between these elements and refer back to it throughout the lesson.
> See json_data_persistence.png


### We Do: Serialization in Java

Open Movie.java

We're going to have the Movie class implement Serializable. We have to do this in order to pass the Movie object to another activity. In this case, a FavouritesActivity (which we haven't created yet)

> In computer science, in the context of data storage, serialization is the process of translating data structures or object state into a format that can be stored or transmitted

> Deserialization is the process of converting the serialized form of an object back into a copy of the object.

Although Serializable is an interface, it has no methods that we need to implement. It is simply a "flag" or "marker" that says we are allowing this object to be serialized by the JVM.

```java
//Movie.java

import java.io.Serializable;

public class Movie implements Serializable{
    //SAME AS BEFORE
}

```


### You Do

> TASK:

```
1. Create a new activity called FavouritesActivity
2. Set MainActivity as the ParentActivity
3. Set the movie as a Tag in the TopMoviesAdapter's listItemView.
4. Create a getMovie(View listItem) method, which will be attached to the list_item's onClick, and get the tag back.
5. Update the getMovie method, adding a new Intent and add the Movie object as an extra
6. Update the getMovie method to start the FavouritesActivity
```

> SOLUTION:

```java
//TopMoviesActivity

public void getMovie(View listItem) {
    Movie movie = (Movie) listItem.getTag();
    Log.d("Movie Title: ", movie.getTitle());

    Log.d("Selected Movie: ", movie.getTitle());

    Intent intent = new Intent(this, FavouritesActivity.class); // UPDATED
    intent.putExtra("movie", movie); // UPDATED

    startActivity(intent); // UPDATED
}

```

Let's run it in our emulator. We should be taken to a new blank activity (FavouritesActivity) when we click on a movie item.


### I Do: Using Shared Preferences & JSON

Shared preferences use the ```SharedPreferences``` class.

This class gives us a general framework that lets us save and retrieve persistent key-value pairs of primitive data types. We can use SharedPreferences to save any primitive data: booleans, floats, ints, longs, and Strings. This data will persist across user sessions (even if you kill your app).

JSON is a common way to store data. And it's going to be useful for us because we can store JSON as a String. Therefore we can store a JSON string (which represents a Java object) in SharedPreferences.

At first we want to store one simple key-value pair in our shared preferences: The title of our favourite movie.

Here is the plan:
> DRAW ON BOARD:
> 1. Click on a movie in our ListView
> 2. Get the movie from the intent in our FavouritesActivity
> 2. Save it to SharedPreferences.
> 3. Display the title of the favourite movie in the Listview


We'll have to import SharedPreferences. Also, we'll have to create a string resource called ```preference_file_key```. We'll give it the value "FAVOURITES".

We can think of this key almost as the name of our database.

Remember SharedPreferences works as a key/value system. So we're going to attempt to get the value associated with the key "MyFavourites". The second argument for the getString method is what we'll get back if "MyFavourites" doesn't yet exist.

```java
//FavouritesActivity
SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
String favouriteMovie = sharedPref.getString("MyFavourite", "Nothing selected");
Log.d("Favourite Movie:", favouriteMovie);
```

To add a key/value pair to SharedPreferences we need to get a handle to and Editor object.

We're also going to show a Toast! A toast is like a popup type thing that we can use for confirmations.

First, we want to get a hold of the movie that we store on the intent's extras. Since we saved it as a Serializable, we have to cast it back to make it a Movie object.

```java
Intent intent = getIntent();
Movie selectedMovie = (Movie) intent.getSerializableExtra("movie");
```

Now we can create an editor, and ask it to save our favourite movie's title.

```java
//FavouritesActivity
SharedPreferences.Editor editor = sharedPref.edit();
String selectedTitle = selectedMovie.getTitle()
editor.putString("MyFavourite", selectedTitle);
editor.apply();
```

Adding a toast is super easy:

```java
Toast.makeText(this, selectedTitle + "is set as favourite! Hurrah!", Toast.LENGTH_LONG).show();
```

If we restart our application, and click on a movie, we should see the toast popping up with the selected movie's title.

If we click on the back button, then click on another movie, we can see in the logs as it changes the saved favourite movie title from SharedPreferences!

One last step: Let's display this movie title on the FavouritesActivity.

Go to the design view of our favourites_activity.xml, and drag&drop a TextView. Make it big enough to cover most of the screen, add constraints to all 4 sides, and increase the font size. Finally, let's give it an id of @+id/favourites (plural, don't forget we'll change it to show multiple favourites soon)!

Once it's done, go back to our FavouritesActivity and add the following:

```java

public class FavouritesActivity extends AppCompatActivity {

    TextView favourites; // NEW

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        // as before
        favourites = findViewById(R.id.favourites); // NEW
        favourites.setText(selectedTitle); //NEW
    }
}

```

Run it again and see the movie title on our screen!

But now we want to store multiple favourite movies! How can we achieve this if we can only store key-value pairs?

We want to store an ArrayList of our favourite movies. First, we'll have to convert the ArrayList to a String and for that, we'll need to use the GSON library.

GSON: A Java serialization/deserialization library that can convert Java Objects into JSON and back.

> NOTE: This is not quite the same as having a class in Java implement Serializable.

Let's add it to our Gradle file dependencies.

```java
// build.gradle (Module: app)

compile 'com.google.code.gson:gson:2.3.1' // NEW

```

Then we have to change our favourites activity. When we are getting back our favourite movies, it's not going to be a single title string as default. We want it to be an arraylist of movies.

```java
//FavouritesActivity
SharedPreferences sharedPref = getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
String favouriteMovies = sharedPref.getString("MyFavourites", new ArrayList<Movie>().toString()); // UPDATE

```

Next, we need to deserialize the ArrayList using the GSON library.

> We need a TypeToken in order to tell Gson what type of thing (i.e. an ArrayList of Movies) that the JSON should be turned into.

```java
//FavouritesActivity
Gson gson = new Gson();
TypeToken<ArrayList<Movie>> movieArrayList = new TypeToken<ArrayList<Movie>>(){};
ArrayList<Movie> myFavourites = gson.fromJson(favouriteMovies, movieArrayList.getType());
Log.d("myFavourites", myFavourites.toString());
```

At this point myFavourites is an ArrayList of Movie objects. So now, we can add the Movie we passed from the main activity. Nice!

```java
//FavouritesActivity
Movie selectedMovie = (Movie) getIntent().getSerializableExtra("movie");
myFavourites.add(selectedMovie);
Log.d("myFavourites", myFavourites.toString());
```

We have to change our editor. We are not saving a simple string back anymore, so we have to ask the gson object to "jsonify" our arraylist - essentially turn it into a string!

```java
// FavouritesActivity
editor.putString("MyFavourites", gson.toJson(myFavourites)); //Updated
```

Finally, change our displayed string to a concatenated one that's made up of the title of the movie, plus the year.

```java
//FavouritesActivity

TextView list = (TextView)findViewById(R.id.favourites_list);
String movieString = "";

for(Movie m : myFavourites){
    movieString += m.getTitle() + " " + m.getYear() + "\n";
}

list.setText(movieString);
```

Run the app and it should display a the movie we clicked on.

Now our favourites list is being persisted to SharedPreferences. Our work here is done.

### Summary

Have we hit our learning objectives?

- Know what data persistence options there are in Android
- Understand serialization and deserialization
- Be able to store JSON in SharedPreferences
- Be able to implement a Toast
