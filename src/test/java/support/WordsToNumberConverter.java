package support;

import java.util.HashMap;
import java.util.Map;

public class WordsToNumberConverter {
    private static final Map<String, Integer> wordToNumberMap = new HashMap<>();

    static {
        wordToNumberMap.put("zero", 0);
        wordToNumberMap.put("one", 1);
        wordToNumberMap.put("two", 2);
        wordToNumberMap.put("three", 3);
        wordToNumberMap.put("four", 4);
        wordToNumberMap.put("five", 5);
        wordToNumberMap.put("six", 6);
        wordToNumberMap.put("seven", 7);
        wordToNumberMap.put("eight", 8);
        wordToNumberMap.put("nine", 9);
        // Add more mappings as needed
    }

    public static int convertWordsToNumber(String words) {
        String[] wordArray = words.split(",\\s*");
        StringBuilder numberBuilder = new StringBuilder();

        for (String word : wordArray) {
            Integer number = wordToNumberMap.get(word.toLowerCase());
            if (number != null) {
                numberBuilder.append(number);
            } else {
                throw new IllegalArgumentException("Invalid word: " + word);
            }
        }

        return Integer.parseInt(numberBuilder.toString());
    }

    public static String runConverter(String input) {
        try {
            int result = convertWordsToNumber(input);
            return String.valueOf(result); // Return the result as a string
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return e.getMessage(); // Return the error message
        }
    }
}