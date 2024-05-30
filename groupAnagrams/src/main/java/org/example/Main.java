package org.example;

import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<strs.length; i++){
            boolean isAvailable = true;
            List<String> temp = new ArrayList<>();

            if(!ans.isEmpty()){
                for(List<String> a : ans){
                    if(a.contains(strs[i])){
                        isAvailable = false;
                        break;
                    }
                }
            }

            if(isAvailable) {
                temp.add(strs[i]);
                for(int j=i+1; j< strs.length; j++ ) {
                    if(calcASCII(strs[i])==calcASCII(strs[j])){
                        temp.add(strs[j]);
                    }
                }
                ans.add(temp);
            }
        }

        return ans;
    }

    private static int calcASCII(String str) {
        int sum=0;
        for(int i=0; i<str.length(); i++){
            sum=sum+str.charAt(i);
        }

        return sum;
    }
}