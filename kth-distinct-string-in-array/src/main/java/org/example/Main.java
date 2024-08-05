package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        String result = main.kthDistinct(new String[]{"d","b","c","b","c","a"}, 2);
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i< arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], 2);
            }else {
                map.put(arr[i],1 );
            }
        }

        List<String> distinct = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            int count = map.get(arr[i]);
            if(count==1){
                distinct.add(arr[i]);
            }
        }


        if(distinct.size()>=k){
            return distinct.get(k-1);
        }

        return "";
    }
}