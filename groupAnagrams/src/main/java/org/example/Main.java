package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            if(map.containsKey(orderStr(strs[i]))) {
                List<Integer> ints = map.get(orderStr(strs[i]));
                ints.add(i);
                map.put(orderStr(strs[i]), ints);
            } else {
                List<Integer> ints = new ArrayList<>(List.of(i));
                map.put(orderStr(strs[i]), ints);
            }
        }

        for (String key : map.keySet()) {
            ans.add(map.get(key).stream().map(value->strs[value]).toList());
        }

        return ans;
    }

    public static  String  orderStr(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = new char[str.length()];

        for(int i=0; i<str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        Arrays.sort(chars);

        for(int i=0; i<chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}