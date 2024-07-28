package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        main.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer , Integer> map = new HashMap<>();

        for(int i=0; i<arr2.length; i++) {
            map.put(arr2[i], i);
        }

        for(int i=0; i< arr1.length; i++) {
            if(map.containsKey(arr1[i])){
                int pos = map.get(arr1[i]);
                arr1[pos] = arr1[i];
            }
        }


        return arr1;
    }
}