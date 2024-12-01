import java.io.*;
import java.util.*;

public class CompoundWordSolver {
    public static void main(String[] args) {
        String filePath = "Input_02.txt"; // Specify the file path
        findTopCompoundWords(filePath);
    }

    public static void findTopCompoundWords(String filePath) {
        long startTime = System.currentTimeMillis();

        List<String> wordList = loadWordsFromFile(filePath);
        TrieNode rootNode = new TrieNode();

        // Insert each word into the Trie
        for (String word : wordList) {
            insertWordIntoTrie(rootNode, word);
        }

        // Sort words by length in descending order
        wordList.sort((word1, word2) -> word2.length() - word1.length());

        String longestCompoundWord = "";
        String secondLongestCompoundWord = "";

        for (String word : wordList) {
            if (isCompoundWord(word, rootNode, 0, 0)) {
                if (longestCompoundWord.isEmpty()) {
                    longestCompoundWord = word;
                } else {
                    secondLongestCompoundWord = word;
                    break; // Stop after finding both longest and second longest compound words
                }
            }
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("Longest Compound Word: " + longestCompoundWord);
        System.out.println("Second Longest Compound Word: " + secondLongestCompoundWord);
        System.out.println("Processing time for file " + filePath + ": " + elapsedTime + " milliseconds");
    }

    private static List<String> loadWordsFromFile(String filePath) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return words;
    }

    // Definition of Trie Node
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private static void insertWordIntoTrie(TrieNode rootNode, String word) {
        TrieNode currentNode = rootNode;
        for (char letter : word.toCharArray()) {
            currentNode = currentNode.children.computeIfAbsent(letter, key -> new TrieNode());
        }
        currentNode.isEndOfWord = true;
    }

    private static boolean isCompoundWord(String word, TrieNode rootNode, int index, int partCount) {
        TrieNode currentNode = rootNode;
        for (int i = index; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!currentNode.children.containsKey(letter)) {
                return false;
            }
            currentNode = currentNode.children.get(letter);
            if (currentNode.isEndOfWord) {
                if (i == word.length() - 1) {
                    return partCount >= 1; // Ensure it's formed from at least two words
                }
                if (isCompoundWord(word, rootNode, i + 1, partCount + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
