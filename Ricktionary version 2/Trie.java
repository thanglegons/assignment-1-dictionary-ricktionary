import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Trie {
    private static final int ALPHABET_SIZE = 26;
    private int vocabNum = 0;

    static class Node {
        public Node[] children;
        public Word containID;
        public int count;

        public Node() {
            this.children = new Node[Trie.ALPHABET_SIZE];
            this.containID = null;
        }
    }

    Node treeRoot;

    public Trie() {
        treeRoot = new Node();
    }

    public int getVocabNum() {
        return this.vocabNum;
    }

    public void insertToTree(Word thisWord) {
        String word = thisWord.getWord_target().toLowerCase();
        Node tree = treeRoot;
        for (int i = 0; i < word.length(); i++) {
            int charToInt = word.charAt(i) - 'a';
            if (tree.children[charToInt] == null) {
                tree.children[charToInt] = new Node();
            }
            tree = tree.children[charToInt];
        }
        if (tree.containID == null) {
            this.vocabNum += 1;
        }
        tree.containID = thisWord;
    }

    private class FindMore {
        ArrayList<Word> results;

        public FindMore() {
            results = new ArrayList<>();
        }

        private void getWord(Node node) {
            if (node.containID != null) {
                results.add(node.containID);
            }
            for (int i = 0; i < Trie.ALPHABET_SIZE; i++) {
                if (node.children[i] != null) {
                    getWord(node.children[i]);
                }
            }
        }

        public ArrayList<Word> commonPrefix(Node curNode, int maxNext) {
            getWord(curNode);
            ArrayList<Word> trimmedRes = new ArrayList<>();
            for (Word word : results) {
                trimmedRes.add(word);
                maxNext -= 1;
                if (maxNext == 0) {
                    break;
                }
            }
            return trimmedRes;
        }

    }

    public ArrayList<Word> searchInTree(String word, int maxNext) {
        word = word.toLowerCase();
        ArrayList<Word> results = new ArrayList<>();
        Node tree = treeRoot;
        boolean canFindWord = true;
        for (int i = 0; i < word.length(); i++) {
            int charToInt = word.charAt(i) - 'a';
            if (tree.children[charToInt] == null) {
                canFindWord = false;
                break;
            }
            tree = tree.children[charToInt];
        }
        if (tree.containID == null) {
            canFindWord = false;
        }
        if (canFindWord) {
            FindMore next = new FindMore();
            results = next.commonPrefix(tree, maxNext);
        } else {
            // Develop later
        }
        return results;
    }
}