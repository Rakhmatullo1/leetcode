package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        int max = main.majorityElement(new int[] {3,3,4});
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int get = map.get(nums[i]);
                get=get+1;
                map.put(nums[i], get);
            } else {
                map.put(nums[i],1 );
            }
        }

        return map.keySet().stream().filter(key->map.get(key)> nums.length/2).findFirst().get();
    }
}