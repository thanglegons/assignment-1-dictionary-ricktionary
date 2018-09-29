import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dictionary = new Dictionary();
    private Scanner scanner;

    public void insertFromCommandLine() {
        int numberOfWord = 0;
        numberOfWord = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfWord; i++) {
            String word, explain;
            word = scanner.nextLine();
            explain = scanner.nextLine();
            dictionary.insertWord(word, explain);
        }
    }


    public ArrayList<Word> getWordList() {
        return dictionary.getWordList();
    }
}
