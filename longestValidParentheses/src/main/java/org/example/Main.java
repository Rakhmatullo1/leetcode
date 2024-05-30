package org.example;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses(""));
    }

    public static int longestValidParentheses(String s) {
        String[] strings = s.split("");
        String maxSubList = "";
        int answer;
        for (int i = 0; i < strings.length; i++) {
            String temp = strings[i];
            for(int j=i+1; j<strings.length; j++) {
                String[] h = temp.split("");
                if(Objects.equals(h[h.length - 1], "(") && Objects.equals(strings[j], ")")) {
                    temp = temp + strings[j];
                    continue;
                }
                if(Objects.equals(h[h.length - 1], ")") && Objects.equals(strings[j], ")")){
                    break;
                }
                if(Objects.equals(h[h.length - 1], "(") && Objects.equals(strings[j], "(")){
                    break;
                }
                if(Objects.equals(h[h.length - 1], ")") && Objects.equals(strings[j], "(")){
                    temp= temp+strings[j];
                }
            }
            if(maxSubList.length()<temp.length()){
                maxSubList = temp;
            }
        }

        answer = maxSubList.length();

        if(maxSubList.length()==0) {
            return 0;
        }

        if(Objects.equals(maxSubList.split("")[maxSubList.length() - 1], "(")){
            answer = answer-1;
        }

        if(Objects.equals(maxSubList.split("")[0], ")")){
            answer = answer-1;
        }
        return answer;
    }
}