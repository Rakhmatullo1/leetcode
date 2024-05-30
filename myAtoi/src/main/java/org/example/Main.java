package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(myAtoi("  0000000000012345678"));
    }
    public static int myAtoi(String s) {
        s =  s.trim();
        String a="";
        boolean isNegative = false;

        if(s.startsWith("+-")||s.startsWith("-+"))
            return 0;

        if(s.startsWith("-")){
            isNegative = true;
            s = s.substring(1);
        }

        if(s.startsWith("+")){
            s = s.substring(1);
        }

        int[] parts = s.chars().toArray();


        for(int i=0; i<parts.length; i++) {
            if(parts[i]<48 ||57 <parts[i]){
                break;
            }

            a =  a + (char) parts[i];
        }

        if(a.isBlank()){
            return 0;
        }

        for(int i=0; i<a.length(); i++) {
            if(i!=a.length()-1){
                if(a.charAt(i)=='0' && a.charAt(i+1)!='0'){
                    a = a.substring(i+1);
                }
            }
        }

        if(a.length()>String.valueOf(Integer.MAX_VALUE).length()){
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if(Long.parseLong(a)>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        if(Long.parseLong(a)>Integer.MAX_VALUE && isNegative){
            return Integer.MIN_VALUE;
        }

        return isNegative ? (-1)*Integer.parseInt(a) : Integer.parseInt(a);
    }
}