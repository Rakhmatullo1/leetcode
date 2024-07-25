package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indexes = new ArrayList<>();

        for(int i=0; i<words.length; i++) {
            if(words[i].contains(String.valueOf(x))) {
                indexes.add(i);
            }
        }

        return indexes;
    }
}