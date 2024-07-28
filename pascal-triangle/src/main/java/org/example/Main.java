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
        main.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows==1) {
            return  List.of(List.of(1));
        }
        if(numRows==2) {
            return List.of(List.of(1), List.of(1,1));
        }

        List<List<Integer>> preResult = generate(numRows-1);
        List<Integer> lastRow = preResult.get(preResult.size()-1);
        List<Integer> newRow = new ArrayList<>();
        for(int i=0; i<lastRow.size() ;i++) {
            if(i==0) {
                newRow.add(1);
            } else {
                newRow.add(lastRow.get(i-1)+lastRow.get(i));
            }
        }
        newRow.add(1);

        ans.addAll(preResult);
        ans.add(newRow);

        return ans;
    }
}