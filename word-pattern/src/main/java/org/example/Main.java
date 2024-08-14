package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> mapOne = new HashMap<>();

        String[] parts = s.split(" ");

        if(parts.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!Objects.equals(map.get(pattern.charAt(i)), parts[i])) {
                    return false;
                }
            } else {
                map.put(pattern.charAt(i), parts[i]);
            }
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (mapOne.containsKey(parts[i])) {
                if (!Objects.equals(mapOne.get(parts[i]), pattern.charAt(i))) {
                    return false;
                }
            } else {
                mapOne.put(parts[i], pattern.charAt(i));
            }
        }

        return true;
    }
}