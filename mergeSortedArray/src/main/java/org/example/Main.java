package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m; i<m+n; i++) {
            nums1[i] = nums2[i-m];
        }

        Arrays.sort(nums1);
    }
}