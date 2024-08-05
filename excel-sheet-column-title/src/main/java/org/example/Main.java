package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.convertToTitle(705));
    }

    public String convertToTitle(int columnNumber) {
        if(columnNumber == 0) {
            return "";
        }

        int index = columnNumber % 26 == 0 ? 26 : columnNumber % 26;
        char character = (char) (index + 64);
        String result = String.valueOf(character);
        return convertToTitle((columnNumber-index)/26) + result;
    }
}