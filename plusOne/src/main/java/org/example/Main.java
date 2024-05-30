package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        plusOne(new int[]{8,9,9,9});
    }
    public static int[] plusOne(int[] digits) {
        List<Integer> ans = Arrays.stream(digits).boxed().collect(Collectors.toList());

        Collections.reverse(ans);

        int addition = 0;

        for(int i=0; i<ans.size(); i++){
            int temp = ans.get(i);

            if(i==0) {
                if(temp==9) {
                   temp = 0;
                  addition=1;
                } else {
                    temp++;
                }
            } else {
                if(temp ==9 && addition == 1){
                    temp = 0;
                } else if (temp<9 && addition==1) {
                    temp++;
                    addition=0;
                }
            }
            ans.set(i, temp);
        }

        if(addition==1) {
            ans.add(1);
        }

        Collections.reverse(ans);

        int[] h = new int[ans.size()];

        for(int i=0; i<ans.size(); i++) {
            h[i] = ans.get(i);
        }

        return h;
    }
}