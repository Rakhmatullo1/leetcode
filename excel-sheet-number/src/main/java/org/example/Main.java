package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.titleToNumber("FXSHRXW"));
    }

    public int titleToNumber(String columnTitle) {
        int result=0;
        for(int i=columnTitle.length()-1; i>=0; i--) {
            result = result + (int) Math.pow(26, columnTitle.length()-i-1)*(columnTitle.charAt(i)-64);
        }

        return  result;
    }
}