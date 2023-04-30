package com.example.demo;

import java.util.List;
import java.util.Random;

public class SimpleSentences {
    private static final List<String> properNouns = List.of("Peter", "John", "Kevin", "Julian", "Freddy");
    private static final List<String> determiners = List.of("an", "a", "the", "every", "some");
    private static final List<String> commonNouns = List.of("man" , "woman" , "fish" , "elephant" , "unicorn");
    private static final List<String> adjectives = List.of("big", "tiny", "bald", "small");
    private static final List<String> conjunctions = List.of("and", "but", "with", "because");
    private static final List<String> transitiveVerbs = List.of("loves" , "hates" , "sees", "knows" , "looks for" , "finds");
    private static final List<String> intransitiveVerbs = List.of("runs", "jumps", "sits", "sleeps");

/** instance variable used to generate random words from each list **/
    private static final Random random = new Random();

/** A Getter method that picks random items from each array list **/
    private static <T> T getRandomElement(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }
/** This method generates a random sentence by calling the generateSimpleSentence() **/
    private static String generateSentence() {
        StringBuilder sb = new StringBuilder();
        sb.append(generateSimpleSentence());
        if (random.nextDouble() < 0.5) {
            sb.append(" ");
            sb.append(getRandomElement(conjunctions));
            sb.append(" ");
            sb.append(generateSentence());
        }
        return sb.toString();
    }

/** This method generates a random sentence by calling the generateNounPhrase() **/
    private static String generateSimpleSentence() {
        StringBuilder sb = new StringBuilder();
        sb.append(generateNounPhrase());
        sb.append(" ");
        sb.append(generateVerbPhrase());
        return sb.toString();
    }

/**This method generates a noun phrase by selecting either
* a random proper noun or a determiner followed by a determiners using the if statement.
* It may also add an adjective or the common noun and/or a relative clause using the "who" pronoun. **/
    private static String generateNounPhrase() {
        StringBuilder sb = new StringBuilder();
        if (random.nextDouble() < 0.5) {
            sb.append(getRandomElement(properNouns));
        } else {
            sb.append(getRandomElement(determiners));
            if (random.nextDouble() < 0.5) {
                sb.append(" ");
                sb.append(getRandomElement(adjectives));
            }
            sb.append(" ");
            sb.append(getRandomElement(commonNouns));
            if (random.nextDouble() < 0.5) {
                sb.append(" who ");
                sb.append(generateVerbPhrase());
            }
        }
        return sb.toString();
    }

/** This method generates a verb phrase by randomly selecting a condition:
* an intransitive verb, a transitive verb followed by a noun phrase,
 or the copula "is" followed by an adjective. **/
    private static String generateVerbPhrase() {
        StringBuilder sb = new StringBuilder();
        if (random.nextDouble() < 0.33) {
            sb.append(getRandomElement(intransitiveVerbs));
        } else if (random.nextDouble() < 0.66) {
            sb.append(getRandomElement(transitiveVerbs));
            sb.append(" ");
            sb.append(generateNounPhrase());
        } else {
            sb.append("is ");
            sb.append(getRandomElement(adjectives));
        }
        return sb.toString();
    }

    /** The main method that calls in the recursive methods to generates and prints
    * 5 random sentences using the generateSentence() method and the generateSimpleSentence() method.**/
    public static void main(String[] args) {
        System.out.println("Auto generated for simple sentences and long sentences");
        for (int i = 0; i < 5; i++) {
            System.out.println();
            System.out.println(generateSimpleSentence());
            System.out.println(generateSentence());


        }
    }

}
