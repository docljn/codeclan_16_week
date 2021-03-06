# Enums

### Objectives

- Know what an enum is
- Be able to use an enum
- Know how to add fields and methods to an enum

### Duration - 1 hour

# Intro

Previously, we have often used "magic strings" to represent sets of possible properties. For example, our bank account might be "personal" or "business". An order status might be "received", "dispatched" or "processing".

Let's have a look at an example

> Give out the starter code

Let's add another test.

```java
//CardTest.java

@Test
public void suitCanBeMispelled(){
  card = new Card("Heeaarts");
  assertEquals("Heeaarts", card.getSuit());
}
```

If we were to write a method on a card game to find a card of a given suit, it would match "Hearts" but not "Heeaarts". What if we added it as lowercase, uppercase? It becomes a nightmare.

Let's try another little test.

```java
//CardTest.java

@Test
public void suitCanBeBananas(){
  card = new Card("Bananas");
  assertEquals("Bananas", card.getSuit());
}
```

Uh, we've managed to set Bananas as the suit for the Card... that's not great either. Cards don't tend to come in Banana... unless you've get a set for a particular game.

If we use strings, we can't stop users passing invalid values.

This is where enums come in. Enums allow us to define a set of possible values, and nothing outside of that set is permitted. This is great news for searching and stopping unexpected things happening.

```
#IntelliJ 
Create a new class in the java folder called SuitType.java and set its type to enum from drop down. 

Right click > new > Java Class.
name class SuitType and in drop down change to Enum.

```

```java
//SuitType.java

public enum SuitType {
  HEARTS,
  DIAMONDS,
  SPADES,
  CLUBS
}
```

The "enum" keyword sits where we used to declare a class. An enum is different, it has no properties and (usually :/) no methods like we had before. It simply acts as a container of values we can use.

We tend to use uppercase for the value names.

Let's refactor our Card to use the SuitType enum.

```java
//Card.java

public class Card {

  private SuitType suit; //UPDATED

  public Card(SuitType suit) { //UPDATED
    this.suit = suit;
  }

  public SuitType getSuit(){ //UPDATED
    return this.suit;
  }

}
```

Now our tests won't compile, because we are throwing around strings all over the place. We've got a bit of work to do. Let's comment out the banana and misspell test for now.

```java
//CardTest.java

import static org.junit.Assert.*;
import org.junit.*;

public class CardTest {

  Card card;

  @Before
  public void before(){
    card = new Card("Hearts");
  }

  @Test
  public void canGetSuit(){
    assertEquals("Hearts", card.getSuit());
  }

  //@Test
  //public void suitCanBeMispelled(){
  //  card = new Card("Heeaarts");
  //  assertEquals("Heeaarts", card.getSuit());
  //}

  //@Test
  //public void suitCanBeBananas(){
  //  card = new Card("Bananas");
  //  assertEquals("Bananas", card.getSuit());
  //}

}
```

Let's go about fixing our test. We need to use our Enum instead of the string, since an enum declares a new type, in our case SuitType. SuitType is it's own thing, not a String or an int or a Card. Just like a class behaves.

To use our shiny new enum, we need to use the enum name then the key we want to access.

```java
//CardTest.java

import static org.junit.Assert.*;
import org.junit.*;

public class CardTest {

  Card card;

  @Before
  public void before(){
    card = new Card(SuitType.HEARTS); //UPDATED
  }

  @Test
  public void canGetSuit(){
    assertEquals("Hearts", card.getSuit());
  }

  // same as before

}
```

This will still fail, since our test is comparing it with the string "Hearts". One way to fix this is to call toString() on the value, but this negates the point of using an enum. We can actually just compare Enum values directly using the type itself.

```java
//CardTest.java

import static org.junit.Assert.*;
import org.junit.*;

public class CardTest {

  Card card;

  @Before
  public void before(){
    card = new Card(SuitType.HEARTS); //UPDATED
  }

  @Test
  public void canGetSuit(){
    assertEquals(SuitType.HEARTS, card.getSuit());
  }

  // same as before

}
```

Cool we are all good!

Enums are extremely powerful for giving us more control over our code and what gets passed to our methods.

[TASK:] Create an enum for card values that can be passed to the card

# Enum Fields and Methods

One of the things you can do is add a value to an enum, known as a ___field___. This means that we can create something which looks like a key-value pair in our enum. For example, say we wanted to associate each item in our `ValueType` enum with the value for that card. We could add some kind of switch statement wherever we use the enum in our code, but we can do something like this inside our enum.

When we add such a value to our enum, then we also need to add a getter to the enum, so that we can get this value back.

So let's write a test that, say, if we have a Queen then it's value should be 10.


```java
//CardTest.java

    @Test
    public void queenHasValue10(){
        card = new Card(SuitType.HEARTS, ValueType.QUEEN);
        assertEquals(10, card.getValueFromEnum());
    }
```

So we are testing a `getValueFromEnum()` method on our `Card` class. This method is going to call a 'getter' on our enum. Let's add the ``getValueFromEnum()`` method now:

```java
//Card.java

    public int getValueFromEnum() {        //ADDED METHOD
        return this.value.getValue();
    }

```

So now we need to add our value to our field. We can add a variable (like an instance variable in a class) to our enum:

```java
//ValueType.java

public enum ValueType {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING; //MODIFIED TO ADD SEMI-COLON

    private final int value; //ADDED

}
```

> note that we now need to add a sem-colon after the final entry in the enum list.

This value is declared as `final`, which means that it will never change.

As our enum has a field, we now need to create a constructor. This constructor takes an argument, which is used to set the value of the field.

```java
//ValueType.java

public enum ValueType {
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING;

    private final int value; //ADDED

    ValueType(int value) { //ADDED
        this.value = value;
    }
}
```

So we are passing a value to our constructor. But where does this value come from? How do we call this constructor? 

When we add an item to our enum, the constructor is called for that item. Since our constructor takes a value we then need to put that value in round brackets after the item we are adding e.g. if we are creating an item in our enum called QUEEN with the value 10 then we would have:

```java
  QUEEN(10)
```

This means that when we add this item to our enum, it will call the constructor for the enum item QUEEN, passing it the value 10. We can then do the same for the other items in our enum e.g.:

```java
//ValueType.java

public enum ValueType {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private int value;

    ValueType(int value) { //ADDED
        this.value = value;
    }
}
```

We can now add a `getter` for our value - yes! we can have methods inside an enum. This will simply return the associated with the item in the enum:

```java
//ValueType.java

public enum ValueType {
    ACE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10);

    private int value;

    ValueType(int value) { //ADDED
      this.value = value;
    }

    public int getValue() {
      return value;
    }
}
```

Thus if we wanted to get the value associated with the item QUEEN in our enum then we could write something like:

```java

  int cardValue = ValueType.QUEEN.getValue();

```

Our test should now pass. 

You can now see that our enum is starting to look like a class. In fact an enum is a special type of a Java class.

# Other useful things
Say wanted to get a list of all the entries in our enum. We can do this using the `values` method e.g.:

```java
  SuitType[] suits = SuitType.values();
```

This returns an array of all the items in the enum.

Let's write a test to demonstrate this:

```java
//CardTest.java

    @Test
    public void canGetAllSuits(){
        SuitType[] expected = {SuitType.HEARTS, SuitType.DIAMONDS, Suit.SPADES, SuitType.CLUBS};
        SuitType[] suits = SuitType.values();
        assertEquals(4, suits.length);
        assertArrayEquals(expected ,suits);
    }
```

We could then do useful things with this array, like loop through it.

## Recap

* An enum is a special type of data type which is basically a collection (set) of constants.

* An enum allows a variable to be a set of pre-defined constants (e.g. days of the week, compass directions)

* An enum can contain constants, which allow us to associate a specific value for element in an enum, and methods.
