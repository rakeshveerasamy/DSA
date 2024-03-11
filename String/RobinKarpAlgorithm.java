//$Id$
package practice.test.pkg;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Test {
	private static final int PRIME = 101; // A prime number used for hashing

    public static List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();

        int m = pattern.length(); // Length of the pattern
        int n = text.length();    // Length of the text
        long patternHash = hash(pattern, m); // Hash value of the pattern
        long textHash = hash(text.substring(0, m), m); // Hash value of the initial substring of text

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && text.substring(i, i + m).equals(pattern)) {
                result.add(i);
            }
            if (i < n - m) {
                textHash = rehash(textHash, text.charAt(i), text.charAt(i + m), m);
            }
        }

        return result;
    }

    private static long hash(String s, int length) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash += s.charAt(i) * Math.pow(PRIME, length - i - 1);
        }
        return hash;
    }

    private static long rehash(long oldHash, char oldChar, char newChar, int length) {
        long newHash = oldHash - oldChar * (long) Math.pow(PRIME, length - 1);
        newHash = newHash * PRIME + newChar;
        return newHash;
    }

    public static void main(String[] args) {
        String text = "ababcababcabcababc";
        String pattern = "abc";
        List<Integer> occurrences = search(text, pattern);
        if (occurrences.isEmpty()) {
            System.out.println("Pattern not found in the text.");
        } else {
            System.out.println("Pattern found at positions: " + occurrences);
        }
    }


}

