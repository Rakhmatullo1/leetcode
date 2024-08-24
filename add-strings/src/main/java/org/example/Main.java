package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public String addStrings(String num1, String num2) {
        String[] nums1 = num1.split("");
        int length = Math.max(num1.length(), num2.length());
        String[] nums2 = num2.split("");
        String[] temp = new String[nums2.length];
        String[] temp1 = new String[length];
        if (nums1.length < nums2.length) {
            temp = new String[nums1.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = nums1[temp.length - i - 1];
            }
            nums1 = new String[length];
            for (int i = 0; i < temp.length; i++) {
                nums1[i] = temp[i];
            }

            for (int i = temp.length; i < length; i++) {
                nums1[i] = "0";
            }
            temp = new String[length];
            for (int i = 0; i < length; i++) {
                temp[i] = nums1[temp.length - i - 1];
            }
            nums1 = temp;

        } else if (nums2.length < nums1.length) {
            for (int i = 0; i < temp.length; i++) {
                temp[i] = nums2[temp.length - i - 1];
            }
            nums2 = new String[length];
            for (int i = 0; i < temp.length; i++) {
                nums2[i] = temp[i];
            }

            for (int i = temp.length; i < length; i++) {
                nums2[i] = "0";
            }
            temp = new String[length];
            for (int i = 0; i < length; i++) {
                temp[i] = nums2[temp.length - i - 1];
            }
            nums2 = temp;
        }



        for (int i = 0; i < length; i++) {
            int result = Integer.parseInt(nums1[i]) + Integer.parseInt(nums2[i]);
            if (i != 0 && result > 9) {
                for(int j=i-1; j>=0; j--) {
                    temp1[j] = String.valueOf(Integer.parseInt(temp1[j])+1);
                    temp1[j+1] = String.valueOf(result % 10);
                    result = Integer.parseInt(temp1[j]);
                    if(Integer.parseInt(temp1[j])<10) {
                        break;
                    }
                }
            } else {
                temp1[i] = String.valueOf(result);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(temp1[i]);
        }
        return sb.toString();
    }
}