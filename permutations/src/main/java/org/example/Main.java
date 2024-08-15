package org.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        main.permute(new int[]{1});

    }

    public List<List<Integer>> permute(int[] nums) {
        return permute(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    private List<List<Integer>> permute(List<Integer> ints) {
        List<List<Integer>> result = new ArrayList<>();
        if(ints.size()==1){
            List<Integer> parts = new ArrayList<>(ints);
            result.add(parts);
            return result;
        }

        if(ints.size()==2) {
            List<Integer> parts = new ArrayList<>(ints);
            result.add(parts);
            Collections.reverse(ints);
            result.add(ints);
            return  result;
        }

        for(int i=0; i<ints.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(ints.subList(0,i));
            temp.addAll(ints.subList(i+1, ints.size()));

            List<List<Integer>> resultOne = permute(temp);
            for(List<Integer> tempOne : resultOne){
                List<Integer> hh = new ArrayList<>();
                hh.add(ints.get(i));
                hh.addAll(tempOne);
                if(!result.contains(hh)){
                    result.add(hh);
                }
            }
        }

        return result;
    }


}