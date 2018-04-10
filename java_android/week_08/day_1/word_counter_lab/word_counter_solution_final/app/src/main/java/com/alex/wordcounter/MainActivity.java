package com.alex.wordcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void enterTextClicked(View view){
    final EditText enterText = (EditText) view;
    enterText.setText("It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).");
  }

  public void countWordsButtonClicked(View view){
    final TextView showCounts = findViewById(R.id.main_showCounts);
    final EditText enterText = findViewById(R.id.main_enterText);
    String enterTextWords = enterText.getText().toString();
    final WordCounter wordCounter = new WordCounter(enterTextWords);
    String wordCount = "Word Count: " + String.valueOf(wordCounter.getWordCount());
//    String wordHashMap = "Word Counts:  " + String.valueOf(wordCounter.getWordOccurences().toString());
    String wordArrayList = "Sorted Word Counts:  " + String.valueOf(wordCounter.getSortedWordOccurrences().toString());
//    showCounts.setText(wordCount + "\n" + wordHashMap + "\n" + wordArrayList);
    showCounts.setText(wordCount + "\n" + wordArrayList);

  }



}
