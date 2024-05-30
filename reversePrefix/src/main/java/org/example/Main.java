package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
    public static String reversePrefix(String word, char ch) {

        List<Character> list = new ArrayList<>();
        for(int i=0; i<word.length(); i++) {
            if(Objects.equals(word.charAt(i),ch)){
                list.add(word.charAt(i));
                break;
            }
            list.add(word.charAt(i));
        }

        if(!list.contains(ch)) {
            return word;
        }
        Collections.reverse(list);

        StringBuilder answer = new StringBuilder();
        for(Character c : list) {
            answer.append(c.toString());
        }

        return answer +word.substring(list.size());
    }
}