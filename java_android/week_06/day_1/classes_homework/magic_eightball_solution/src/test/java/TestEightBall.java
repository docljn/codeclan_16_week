import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestEightBall {

    EightBall eightBall;
    ArrayList<String> answers;

    @Before
    public void before(){
        answers = new ArrayList<>();
        answers.add("Yes!");
        answers.add("Drink!");
        answers.add("That would be an ecumenical matter");
        eightBall = new EightBall(answers);
    }

    @Test
    public void answersSetUpCorrectly(){
        assertEquals(3, eightBall.answerCount());
    }

    @Test
    public void canGetCopyOfAnswers(){
        ArrayList<String> copy = eightBall.getAnswers();
        boolean expected = answers.equals(copy);
        assertEquals(true, expected);
    }

    @Test
    public void canAddAnswer() {
    eightBall.addAnswer("I love my brick!");
    assertEquals(4, eightBall.answerCount());
    }
}
