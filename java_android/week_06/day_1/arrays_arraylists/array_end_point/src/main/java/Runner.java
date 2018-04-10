public class Runner {

    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        arrayExample.add("Hello");

        String[] results = arrayExample.getWords();

        for (String word : results){
            System.out.println(word);
        }
    }
}
