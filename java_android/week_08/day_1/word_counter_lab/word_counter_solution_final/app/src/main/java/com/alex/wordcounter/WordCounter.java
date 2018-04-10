package com.alex.wordcounter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alex on 22/01/2018.
 */

public class WordCounter {

  private String words;

  public WordCounter(String words){
    this.words = words;
  }

  private String[] splitWordsBySpace(){
    return this.words.split(" ");
  }

  public int getWordCount(){
    return splitWordsBySpace().length;
  }

  public HashMap<String, Integer> getWordOccurences(){

    HashMap<String, Integer> wordOccurences = new HashMap<>();
    for (String word : splitWordsBySpace()){
      word = word.toLowerCase();
      Integer wordCount = wordOccurences.get(word);
      wordCount = wordCount == null ? 0 : wordCount;
      wordOccurences.put(word, wordCount + 1);
    }

    return wordOccurences;
  }

  public ArrayList<Map.Entry> getSortedWordOccurrences(){

    ArrayList<Map.Entry> occurrencesArray = new ArrayList<Map.Entry>(getWordOccurences().entrySet());
    Collections.sort(occurrencesArray, (new Comparator<Map.Entry>() {
      @Override
      public int compare(Map.Entry o1, Map.Entry o2) {
        return (int) o2.getValue() - (int) o1.getValue();
      }
    }));
    return occurrencesArray;
  }

}
