package example.codeclan.com.roompractice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by zsoltpodoba-szalai on 26/01/2018.
 */

public class TodoTest {

    Todo todo;

    @Before
    public void before(){
        todo = new Todo("Buy milk", "Must be skimmed");
    }

    @Test
    public void todoHasName(){
        assertEquals("Buy milk", todo.getName());
    }

    @Test
    public void todoHasDescription(){
        assertEquals("Must be skimmed", todo.getDescription());
    }

}
