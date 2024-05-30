package org.example;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"aaa","aa","aaa"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for(int i=1; i<strs.length; i++) {
            String item = strs[i];
            String[]  itemParts = item.split("");
            String temp = "";

            for(int j=0; j<itemParts.length; j++) {
                if(!(Objects.equals(prefix.split("")[0], itemParts[0]))){
                    temp ="";
                    break;
                }

                if(prefix.startsWith(temp+itemParts[j]))  {
                    temp = temp + itemParts[j];
                } else {
                    break;
                }
            }
            if(prefix.length()>temp.length()) {
                prefix = temp;
            }

        }

        return prefix;
    }
}