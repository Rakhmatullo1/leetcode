package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.getAllPossibilities(3);
    }

    public int climbStairs(int n) {
        if(n==0) {
            return 1;
        }

        if(n==1) {
            return 1;
        }
        return  climbStairs(n-1) + climbStairs(n-2);
    }

    private List<List<Integer>> getAllPossibilities(int n) {
        if(n==1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> part = new ArrayList<>();
            part.add(1);
            result.add(part);
            return result;
        }

        List<List<Integer>> pre = getAllPossibilities(n-1);

        for(int i=0; i<pre.size(); i++) {
            for(int j=0; j<pre.get(i).size(); j++) {
                if(pre.get(i).get(j) == 1) {
                    pre.get(i).add(1);
                    break;
                }

            }
        }

        return pre;
    }
}