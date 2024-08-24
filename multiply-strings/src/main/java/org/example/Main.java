package org.example;

import java.util.Objects;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        String result = main.addTwoString("3876620623801494171", "6529364523802684779");
    }

    public String multiply(String num1, String num2) {
        if(Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
            return "0";
        }
        String[] nums1 = num1.split("");
        String[] nums2 = num2.split("");
        int[][] ans = new int[nums2.length][nums1.length];
        int num1Size = num1.length();
        int num2Size = num2.length();
        // 9876543120000000

        for (int i = 0; i < num2Size; i++) {
            for (int j = 0; j < num1Size; j++) {
                ans[i][j] = Integer.parseInt(nums2[i]) * Integer.parseInt(nums1[j]);
            }
        }

        String[][] ans3 = new String[num2Size][num1Size];
        for(int i=0; i<num2Size; i++) {
            for (int j=0; j<num1Size; j++) {
                StringBuilder sb = new StringBuilder();
                for(int k=0; k<num1Size-1-j; k++) {
                    sb.append("0");
                }
                ans3[i][j] = String.valueOf(ans[i][j])+ sb;
            }
        }

        nums1 = new String[num2Size];

        for (int i = 0; i < num2Size; i++) {
            String result = String.valueOf(ans3[i][0]);
            for (int k = 1; k < num1Size; k++) {
                result = addTwoString(result, ans3[i][k]);
            }
            nums1[i] =result;
        }

        for (int j=0; j<num2Size; j++) {
            StringBuilder sb = new StringBuilder();
            for(int k=0; k<num2Size-1-j; k++) {
                sb.append("0");
            }
            nums1[j] = String.valueOf(nums1[j])+ sb;
        }


        String result = String.valueOf(nums1[0]);
        for (int k = 1; k < num2Size; k++) {
            result = addTwoString(result, nums1[k]);
        }


        return result;
    }

    private String addTwoString(String num1, String num2) {
        // 150 2879 0510 0150
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
                    temp1[j] = String.valueOf(Integer.parseInt(temp1[j])+result/10);
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