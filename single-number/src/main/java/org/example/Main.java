package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> numInMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(numInMap.containsKey(nums[i])) {
                numInMap.put(nums[i],2);
            } else {
                numInMap.put(nums[i], 1);
            }
        }

        return numInMap.keySet().stream().filter(k->numInMap.get(k)==1).findFirst().get();
    }
}