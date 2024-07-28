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
        main.getRow(3);
    }

    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0) {
            return List.of(1);
        }

        if(rowIndex == 1) {
            return List.of(1,1);
        }

        List<Integer> preResult = getRow(rowIndex-1);
        List<Integer> newRow = new ArrayList<>();
        for(int i=0; i<preResult.size(); i++) {
            if(i==0) {
                newRow.add(1);
            } else {
                newRow.add(preResult.get(i-1)+preResult.get(i));
            }
        }

        newRow.add(1);
        return newRow;
    }
}