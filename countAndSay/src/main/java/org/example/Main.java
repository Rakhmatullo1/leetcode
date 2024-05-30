package org.example;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(helperMethod2("1"));
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {

        String param = "1";

        for(int i=0; i<n-1; i++){
            param =  helperMethod2(param);
        }

        return param;
    }

    private  static List<Pair<String, Integer>> helperMethod1(String str) {
        List<Pair<String, Integer>> pairs = new ArrayList<>();

        String[] parts = str.split("");

        for(int i=0; i<parts.length; i++) {
            String num = parts[i];

            if(!pairs.isEmpty() &&  pairs.stream().toList().get(pairs.size()-1).getKey().equals(num)) {
                continue;
            }

            String temp = str.substring(i);
            int sum = 0;
            for(int j=i; j<parts.length; j++){
                if(temp.startsWith(parts[i])){
                    temp = temp.substring(1);
                    sum++;
                } else {
                    sum = j-i;
                    break;
                }
            }

            pairs.add(new Pair<>(num,sum));
        }

        return pairs;
    }

    private static String helperMethod2(String str) {
        List<Pair<String,Integer>> pairs = helperMethod1(str);

        StringBuilder sb = new StringBuilder("");

        for(Pair<String,Integer> pair : pairs ) {
            sb.append(pair.getValue()+pair.getKey());
        }

        return sb.toString();
    }
}