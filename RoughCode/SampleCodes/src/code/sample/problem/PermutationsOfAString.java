package code.sample.problem;

import java.util.LinkedList;
import java.util.List;

public class PermutationsOfAString {

    private static void getAllPermutationHelper(String text, String result, boolean[] trace, List<StringBuilder> results) {

        if (result.length() == text.length()) {
            results.add(new StringBuilder(result));
            return;
        }

        for (int index = 0; index < text.length(); index++) {
            if (trace[index]) continue;
            result += text.charAt(index);
            trace[index] = true;
            getAllPermutationHelper(text, result, trace, results);
            result = result.substring(0, result.length() - 1);
            trace[index] = false;
        }
    }

    public static List<StringBuilder> getAllPermutations(String text) {
        List<StringBuilder> results = new LinkedList<>();
        getAllPermutationHelper(text, "", new boolean[text.length()], results);
        return results;
    }

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter your string: ");
        String inputString = input.nextLine();
        System.out.println("\nInput String: '" + inputString + "'");

        List<StringBuilder> results = getAllPermutations(inputString); // Function call;
        System.out.println("\nNumber of permutations of '" + inputString + "': " + results.size());

        System.out.println("\nAll permutations of '" + inputString + "':\n");
        System.out.println(results);

        input.close();
    }
}
