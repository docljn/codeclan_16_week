public class ArrayExample {

    private String[] words;

    public ArrayExample(){
        this.words = new String[5];
    }

    public String[] getWords() {
        return this.words;
    }

    public int getWordCount(){
        return this.words.length;
    }

    public void add(String word){
        this.words[0] = word;
    }
}
