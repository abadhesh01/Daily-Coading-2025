package code.sample.problem;

import java.util.*;

public class SubsetsOfAString {

    private static void getAllSubsetsHelper(String text, String result, int startIndex, int subsetSize, List<String> results) {

        if (subsetSize == 0) {
            results.add("'" + result + "'");
            return;
        }

        for (int index = startIndex; (index + subsetSize - 1) < text.length(); index++) {
            result += text.charAt(index);
            getAllSubsetsHelper(text, result, index + 1, subsetSize - 1, results);
            result = result.substring(0, result.length() - 1);
        }

    }

    public static List<String> getALlSubsets(String text) {
        List<String> results = new LinkedList<>();
        for (int subsetSize = 0; subsetSize <= text.length(); subsetSize++)
            getAllSubsetsHelper(text, "", 0, subsetSize, results);
        return results;
    }

    public static String removeDuplicateCharsAndSpaces(String text) {
        Set<Character> textCharSet = new LinkedHashSet<>();
        for (int index = 0; index < text.length(); index++)
            textCharSet.add(text.charAt(index));
        textCharSet.removeIf((character) -> character.equals(' '));
        StringBuilder textBuilder = new StringBuilder();
        for (char letter : textCharSet)
            textBuilder.append(letter);
        text = textBuilder.toString();
        return text;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("\nEnter your string: ");
        String text = input.nextLine();
        text = text.trim();
        System.out.println("\nInput text: '" + text + "'");

        text = removeDuplicateCharsAndSpaces(text); // Function Call.
        System.out.println("\nInput text after removal of duplicate characters and space(s): '" + text + "'");

        System.out.println("\nExpected number of subsets of '" + text + "': '" + (int) Math.pow(2, text.length()) + "'");

        List<String> results = getALlSubsets(text); // Function Call.
        System.out.println("\nActual number of subsets of '" + text + "': '" + results.size() + "'");

        System.out.println("\nAll possible subsets of '" + text + "': \n" + results + "\n");
    }
}
