package org.example;

import java.util.List;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        main.maxDistance(List.of(List.of(2, 5), List.of(9999, 10000)));
    }

    public int maxDistance(List<List<Integer>> arrays) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int maxIndexTwo = 0;
        int min = Integer.MAX_VALUE;
        int maxOne = Integer.MIN_VALUE;
        int minOne = Integer.MAX_VALUE;

        for(int i=0; i< arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            if(max < array.get(array.size()-1)) {
                max = array.get(array.size()-1);
                maxIndex = i;
            }
        }

        for(int i=0; i<arrays.size(); i++) {
            if(i!=maxIndex) {
                min = Math.min(min, arrays.get(i).get(0));
            }
        }

        return max - min;
    }
}