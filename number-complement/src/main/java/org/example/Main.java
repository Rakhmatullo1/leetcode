package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {

    }

    public int findComplement(int num) {
        int[] binary = new int[35];
        int id = 0;

        // Number should be positive
        while (num > 0) {
            binary[id++] = num % 2;
            num = num / 2;
        }

        StringBuilder sb = new StringBuilder();

        for(int i= id-1;i>=0; i--) {
            if(binary[i]==1) {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }


}