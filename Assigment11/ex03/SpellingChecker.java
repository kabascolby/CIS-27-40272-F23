// package ex03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SpellingChecker {

    private HashMap<String, Boolean> dictionary;

    public SpellingChecker() {
        dictionary = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dictionary.put(line, true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isCorrectlySpelled(String word) {
        return dictionary.containsKey(word);
    }

    public void checkSpelling(String word) {
        if (isCorrectlySpelled(word)) {
            System.out.println("No mistakes found.");
        } else {
            System.out.println("Possible corrections:");
            // Add one character to the beginning
            for (char c = 'a'; c <= 'z'; c++) {
                String newWord = c + word;
                if (isCorrectlySpelled(newWord)) {
                    System.out.println(newWord);
                }
            }

            // Add one character to the end
            for (char c = 'a'; c <= 'z'; c++) {
                String newWord = word + c;
                if (isCorrectlySpelled(newWord)) {
                    System.out.println(newWord);
                }
            }

            // Remove one character from the beginning
            if (word.length() > 1) {
                String newWord = word.substring(1);
                if (isCorrectlySpelled(newWord)) {
                    System.out.println(newWord);
                }
            }

            // Remove one character from the end
            if (word.length() > 1) {
                String newWord = word.substring(0, word.length() - 1);
                if (isCorrectlySpelled(newWord)) {
                    System.out.println(newWord);
                }
            }

            // Exchange adjacent characters
            for (int i = 0; i < word.length() - 1; i++) {
                StringBuilder newWord = new StringBuilder(word);
                newWord.setCharAt(i, newWord.charAt(i + 1));
                if (isCorrectlySpelled(newWord.toString())) {
                    System.out.println(newWord.toString());
                }
            }
        }
    }

    public static void main(String[] args) {
        SpellingChecker checker = new SpellingChecker();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a word to check:");
        String word = scanner.nextLine();

        checker.checkSpelling(word);
    }
}
