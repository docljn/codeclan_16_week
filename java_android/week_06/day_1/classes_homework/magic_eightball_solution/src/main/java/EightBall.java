import java.util.ArrayList;
import java.util.Collections;

public class EightBall {

    private ArrayList<String> answers;

    public EightBall(ArrayList<String> answers){
        this.answers = answers;
    }

    public ArrayList<String> getAnswers(){
        ArrayList<String> answersCopy = new ArrayList<>(this.answers);
        return answersCopy;
    }

    public int answerCount(){
        return this.answers.size();
    }

    public String randomAnswer(){
         Collections.shuffle(this.answers);
         return answers.get(0);
    }

    public void addAnswer(String answer){
        this.answers.add(answer);
    }
}
