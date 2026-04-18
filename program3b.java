package String_Functions;

import java.util.Random;

public class StringExerciseDemo {

    public static void main(String[] args) {

        System.out.println("=== String Exercise Programs ===");

        String test = " Hello World ";
        String palindromeTest = "A man, a plan, a canal: Panama";

        // Q1
        System.out.println("\n1. isNullOrEmpty:");
        System.out.println(isNullOrEmpty("   ")); // true

        // Q2
        System.out.println("\n2. countOccurrences:");
        System.out.println(countOccurrences("banana", "an")); // 2

        // Q3
        System.out.println("\n3. reverseString:");
        System.out.println(reverseString("Java")); // avaJ

        // Q4
        System.out.println("\n4. isPalindrome:");
        System.out.println(isPalindrome(palindromeTest)); // true

        // Q5
        System.out.println("\n5. removeWhitespace:");
        System.out.println(removeWhitespace(test)); // HelloWorld

        // Q6
        System.out.println("\n6. capitalizeWords:");
        System.out.println(capitalizeWords("java programming is fun"));

        // Q7
        System.out.println("\n7. truncate:");
        System.out.println(truncate("Hello Programming World", 10));

        // Q8
        System.out.println("\n8. isNumeric:");
        System.out.println(isNumeric("12345")); // true
        System.out.println(isNumeric("123a"));  // false

        // Q9
        System.out.println("\n9. generateRandomString:");
        System.out.println(generateRandomString(8));

        // Q10
        System.out.println("\n10. countWords:");
        System.out.println(countWords("Java is very powerful"));
    }

    // Q1
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    // Q2
    public static int countOccurrences(String str, String sub) {
        int count = 0, index = 0;

        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    // Q3
    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // Q4
    public static boolean isPalindrome(String s) {
        if (s == null) return false;

        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversed);
    }

    // Q5
    public static String removeWhitespace(String s) {
        return s.replaceAll("\\s+", "");
    }

    // Q6
    public static String capitalizeWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                      .append(word.substring(1))
                      .append(" ");
            }
        }
        return result.toString().trim();
    }

    // Q7
    public static String truncate(String s, int length) {
        if (s.length() <= length) return s;
        return s.substring(0, length) + "...";
    }

    // Q8
    public static boolean isNumeric(String s) {
        return s != null && s.matches("\\d+");
    }

    // Q9
    public static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < length; i++) {
            result.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return result.toString();
    }

    // Q10
    public static int countWords(String s) {
        if (s == null || s.trim().isEmpty()) return 0;
        return s.trim().split("\\s+").length;
    }
}