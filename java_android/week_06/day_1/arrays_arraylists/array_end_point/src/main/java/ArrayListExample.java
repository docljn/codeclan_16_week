import java.util.ArrayList;

public class ArrayListExample {

    private ArrayList<String> words;

    public ArrayListExample(){
        this.words = new ArrayList<>();
    }

    public int getWordCount() {

        return this.words.size();
    }

    public void addWord(String word){
        this.words.add(word);
    }

    public String getWordAtIndex(int index){
        return this.words.get(index);
    }
}
