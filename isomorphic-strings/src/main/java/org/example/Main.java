package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isIsomorphic("bar", "foo"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> chars = new HashMap<>();
        Map<Character, Character> charsOne = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if(chars.containsKey(s.charAt(i))){
                if(t.charAt(i) != chars.get(s.charAt(i))){
                    return false;
                }
            } else {
                chars.put(s.charAt(i), t.charAt(i));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if(charsOne.containsKey(t.charAt(i))){
                if(s.charAt(i) != charsOne.get(t.charAt(i))){
                    return false;
                }
            } else {
                charsOne.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }
}