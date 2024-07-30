package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int a = main.minimumDeletions("aababbab");
        System.out.println(a);
    }

    public int minimumDeletions(String s) {
        int[] results = new int[s.length()+1];
        int b = 0;
        for(int i=1; i<=s.length(); i++) {
            if(s.charAt(i-1)=='b'){
                results[i] = results[i-1];
                b++;
            } else {
                results[i] = Math.min(results[i-1]+1,b );
            }
        }

        return results[s.length()];
    }
}