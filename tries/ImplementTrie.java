import java.io.*;
import java.util.*;

class Main {


    static class Trie {

        private class TrieNode {
            boolean isEnd;
            TrieNode[] childs;

            TrieNode() {
                childs = new TrieNode[26];
                isEnd = false;
            }

        }

        /**
         * Initialize your data structure here.
         */

        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word.length() == 0)
                return;

            TrieNode currentPointer = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (currentPointer.childs[currentChar - 'a'] == null) {
                    currentPointer.childs[currentChar - 'a'] = new TrieNode();
                }
                currentPointer = currentPointer.childs[currentChar - 'a'];

            }

            currentPointer.isEnd = true;

        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word.length() == 0)
                return true;

            TrieNode currentPointer = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (currentPointer.childs[currentChar - 'a'] == null)
                    return false;
                else
                    currentPointer = currentPointer.childs[currentChar - 'a'];
            }

            return currentPointer.isEnd;

        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix.length() == 0)
                return true;

            TrieNode currentPointer = root;
            for (int i = 0; i < prefix.length(); i++) {
                char currentChar = prefix.charAt(i);
                if (currentPointer.childs[currentChar - 'a'] == null)
                    return false;
                else
                    currentPointer = currentPointer.childs[currentChar - 'a'];
            }

            return true;

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Trie obj = new Trie();

        while (read.ready()) {
            String inp[] = read.readLine().split(" ");

            if (inp[0].equals("insert")) {
                obj.insert(inp[1]);
            } else if (inp[0].equals("search")) {
                System.out.println(obj.search(inp[1]));
            } else if (inp[0].equals("startsWith")) {
                System.out.println(obj.startsWith(inp[1]));
            }
        }

    }
}
