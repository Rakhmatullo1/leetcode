package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(maximumHappinessSum(new int[] {7,50,3},3));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        List<Integer> happinesses = Arrays.stream(happiness).boxed().sorted((a,b)->{
            if(a>b) {
                return -1;
            } else if (a<b) {
                return 1;
            } else  {
                return 0;
            }
        }).collect(Collectors.toList());

        long result = 0;

        for (int i = 0; i < k; i++) {
            result = result + happinesses.get(i);
            if(happinesses.get(i)==0) {
                break;
            }
            if(i != k-1) {
                Integer temp = happinesses.get(i+1);
                if(temp==0) {
                    break;
                }

                if(temp==i) {
                    temp=0;
                } else {
                    temp -= (i+1);
                }

                happinesses.set(i+1, temp);
            }
        }

        return result;
    }
}