package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));
    }

    public static int subsetXORSum(int[] nums) {
        int sum = 0;
        List<Integer> array = Arrays.stream(nums).boxed().toList();
        List<List<Integer>> res = subsets(array);
        for (List<Integer> subset : res) {
            int i = 0;
            for (Integer num : subset) {
                i = i ^ num;
            }
            sum = sum + i;
        }

        return sum;
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