import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> wordList;
    
    public Dictionary(){
        this.wordList = new ArrayList<Word>();
    }

    public void insertWord(String newWord, String newWordExplanation) {
        Word word = new Word(newWord, newWordExplanation, wordList.size() + 1);
        wordList.add(word);
    }

    public ArrayList<Word> getWordList() {
        return wordList;
    }

    public Word getWord(int index) {
        return wordList.get(index);
    }
}
