package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int answer = trap(new int[] {4,2,3});
        System.out.println(answer);
    }

    public static int trap(int[] height) {
        int blueSection=0;
        List<Integer> list = Arrays.stream(height).boxed().collect(Collectors.toList());
        for(int i=0; i< height.length; i++) {

            int init = height[i];

            for(int j=i+1; j< height.length; j++) {
                int end = height[j];

                if (j == height.length - 1 && init > end) {
                    List<Integer> temp = list.subList(i, list.size());
                    Collections.reverse(temp);
                    blueSection = blueSection + trap(temp.stream().mapToInt(k->k).toArray());
                    i=j-1;
                    break;
                }

                if(init <=end) {
                    if(j-i!=1){
                        blueSection=blueSection+getBlueSection(list.subList(i,j));
                        i=j-1;
                    }
                    break;
                }
            }
        }

        return blueSection;
    }

    private static int getBlueSection(List<Integer> list){
        int first = list.get(0);



        int size = first*(list.size()-1);

        for(int i=1; i<list.size(); i++) {
            size = size-list.get(i);
        }

        return size;
    }
}