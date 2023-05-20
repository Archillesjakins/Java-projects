package com.example.demo;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class SpellChecker2 {
    private Set<String> dictionary;


    public void SpellChecker() {
        dictionary = new HashSet<>();
    }

    public void addToDictionary(String word) {
        dictionary.add(word.toLowerCase());
    }

    public boolean isSpelledCorrectly(String word) {
        return dictionary.contains(word.toLowerCase());
    }

    public Set<String> suggestCorrections(String word) {
        HashSet<String> suggestions = new HashSet<>();

        // Generate possible corrections for the misspelled word
        for (String dictWord : dictionary) {
            int distance = calculateLevenshteinDistance(dictWord, word);
            if (distance <= 2) { // Consider words within an edit distance of 2
                suggestions.add(dictWord);
            }
        }

        return suggestions;
    }

    private static int calculateLevenshteinDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int cost = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + cost);
            }
        }

        return dp[word1.length()][word2.length()];
    }

    /**
     * Lets the user select an input file using a standard file
     * selection dialog box. If the user cancels the dialog
     * without selecting a file, the return value is null.
     */
    static File getInputFileNameFromUser() {
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setDialogTitle("Select an Input file");
        int option = fileDialog.showOpenDialog(null);
        if (option != JFileChooser.APPROVE_OPTION)
            return null;
        else
            return fileDialog.getSelectedFile();
    }

    static Set<String> corrections(String badWord, Set<String> dictionary) {
        HashSet<String> suggestions = new HashSet<>();

        // Generate possible corrections for the misspelled word
        for (String dictWord : dictionary) {
            int distance = calculateLevenshteinDistance(dictWord, badWord);
            if (distance <= 2) { // Consider words within an edit distance of 3
                suggestions.add(dictWord);
            }
        }

        return suggestions;
    }


    public static void main(String[] args) {
        System.out.println("\n\n   This program will ask you to select an input file.");
        System.out.println("It will make a list of all the words that occur in the file");
        System.out.println("along with the number of times that each word occurs and print it once.");
        System.out.println("   After reading the input file, the program asks you to print an incomplete word " +
                "to search for closest match for it ");


        SpellChecker spellChecker = new SpellChecker();

        // Let the user select a file
        File inputFile = getInputFileNameFromUser();
        if (inputFile == null) {
            System.out.println("No file selected.");
            return;
        }

        // Use a Scanner to read the words from the selected file
        try (Scanner scanner = new Scanner(inputFile)) {
            scanner.useDelimiter("[^a-zA-Z]+");

            // Process each word token in the file
            while (scanner.hasNext()) {
                String word = scanner.next();
                spellChecker.addToDictionary(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

             // Let the user enter a word to check for corrections
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter a word to check for corrections: ");
        String userInput = inputScanner.next();
        Set<String> correctionSuggestion = corrections(userInput,  spellChecker.dictionary);
        if (correctionSuggestion.isEmpty()) {
            System.out.println( userInput +": [No suggestion found]");
        } else {
            System.out.println("Suggestions for '" + userInput + "': " + correctionSuggestion);
        }
          // Check if words are spelled correctly
//        System.out.println(spellChecker.isSpelledCorrectly("englishman"));  // true
//        System.out.println(spellChecker.isSpelledCorrectly("englishwo"));  // false

        // Suggest corrections for a misspelled word
//        Set<String> suggestions = spellChecker.suggestCorrections("ervin");
//        System.out.println("Suggested corrections for 'erv': " + suggestions);  // [ervin]
//
//        suggestions = spellChecker.suggestCorrections("eroses");
//        System.out.println("Suggested corrections for 'eros': " + suggestions);  // [eroses]
//
//        suggestions = spellChecker.suggestCorrections("blucher");
//        System.out.println("Suggested corrections for 'Bluche': " + suggestions);  // [blusher]
//
//        suggestions = spellChecker.suggestCorrections("englishing");
//        System.out.println("Suggested corrections for 'englishin': " + suggestions);  // [englishing]


    }
}