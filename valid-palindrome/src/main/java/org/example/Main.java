package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        boolean result = main.isPalindrome("0P");
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if( 30<=s.charAt(i)&& s.charAt(i)<=39){
                sb.append(s.charAt(i));
            }

            if(65<=s.charAt(i)&& s.charAt(i)<=90){
                char temp = (char) (s.charAt(i)+32);
                sb.append(temp);
            }

            if( 97<=s.charAt(i) && s.charAt(i)<=122) {
                sb.append(s.charAt(i));
            }
        }
        s = sb.toString();

        if(s.length()==1){
            return false;
        }

        int length = s.length()/2;

        // l 0
        // a 1
        // n 2
        // n 6-2-1
        // a 6-1-1
        // l 6-0-1

        // l 0
        // a 1
        // n 2 = 5-2-1
        // a 3 = 5-1-1
        // l 4 = 5-0-1

        for(int i=0; i<=length; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            }
        }

        return true;
    }
}