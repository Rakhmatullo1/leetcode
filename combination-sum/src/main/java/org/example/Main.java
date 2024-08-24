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
        main.combinationSum(new int[] {2,4,6,10}, 12);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            return result;
        }

        for (int i = 0; i < candidates.length; i++) {
            if(target<candidates[i]) {
                return result;
            }

            List<List<Integer>> get = combinationSum(candidates, target - candidates[i]);
            if(get.isEmpty()) {
                List<Integer> temp = new ArrayList<>();
                temp.add(candidates[i]);
                result.add(temp);
            }
            for(int j=0; j<get.size(); j++) {
                int sum = get.get(j).stream().mapToInt(x->x).sum();
                if(sum+candidates[i] == target){
                    get.get(j).add(candidates[i]);
                }
            }
            result.addAll(get);
        }
        result.

        return result;
    }

}