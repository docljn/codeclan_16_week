package com.alex.wordcounter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by alex on 22/01/2018.
 */

public class WordCounterTest {

  private WordCounter wordCounter;

  @Before
  public void before(){
    String words = "Two two three three three one";
    wordCounter = new WordCounter(words);
  }

  @Test
  public void canGetWordCount(){
    assertEquals(6, wordCounter.getWordCount());
  }

  @Test
  public void canGetWordOccurrences(){
    Integer expectedOne = 1;
    Integer expectedTwo = 2;
    Integer expectedThree = 3;
    assertEquals(expectedOne, wordCounter.getWordOccurences().get("one"));
    assertEquals(expectedTwo, wordCounter.getWordOccurences().get("two"));
    assertEquals(expectedThree, wordCounter.getWordOccurences().get("three"));
  }

  @Test
  public void canGetSortedWordOccurrences(){
    ArrayList<Map.Entry> sortedWordOccurrences = wordCounter.getSortedWordOccurrences();
    assertEquals("three", sortedWordOccurrences.get(0).getKey());
    assertEquals("two", sortedWordOccurrences.get(1).getKey());
    assertEquals("one", sortedWordOccurrences.get(2).getKey());
    assertEquals(3, sortedWordOccurrences.get(0).getValue());
    assertEquals(2, sortedWordOccurrences.get(1).getValue());
    assertEquals(1, sortedWordOccurrences.get(2).getValue());
  }

}
