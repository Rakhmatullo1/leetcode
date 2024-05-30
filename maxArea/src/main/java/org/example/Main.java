package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {2,3,4,5,18,17,6}));
    }

    public static int maxArea(int[] height1) {
        int maxArea = 0;
        int first = 0;
        int last = height1.length-1;

        for(int i=0; i<height1.length; i++) {
            int temp =0;
            if(height1[first]<height1[last]){
                temp = height1[first]* (last-first);
            } else {
                temp = height1[last]* (last-first);
            }

            if(maxArea<temp) {
                maxArea = temp;
            }

            if(height1[first]<height1[last]){
                first++;
            } else {
                last--;
            }

        }
        return maxArea;
    }
}
