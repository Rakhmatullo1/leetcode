package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();


        calcSubset(Arrays.stream(nums).boxed().toList(), res, subset, 0);

        return res;
    }

    public static void calcSubset(List<Integer> A,
                                  List<List<Integer>> res,
                                  List<Integer> subset,
                                  int index) {
        res.add(new ArrayList<>(subset));

        for (int i = index; i < A.size(); i++) {
            subset.add(A.get(i));
            calcSubset(A, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }

    public static List<List<Integer>>
    subsets(List<Integer> A) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();


        calcSubset(A, res, subset, 0);

        return res;
    }
}