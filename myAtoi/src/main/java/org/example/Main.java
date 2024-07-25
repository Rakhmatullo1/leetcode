package org.example;

public class Main {
    public static void main(String[] args) {
        int result = myAtoi("-2147483649");
        System.out.println(result);
    }
    public static int myAtoi(String s) {
        s =  s.trim();
        StringBuilder a= new StringBuilder();
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

        for(int i=0; i< parts.length; i++) {
            if(parts[i] == 48) {
                s = s.substring(1);
            }else {
                break;
            }
        }

        parts = s.chars().toArray();

        for (int part : parts) {
            if (part < 48 || 57 < part) {
                break;
            }

            a.append((char) part);
        }

        if(a.toString().isBlank()){
            return 0;
        }

        if(a.length()>String.valueOf(Integer.MAX_VALUE).length()){
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if(isNegative && Long.parseLong(a.toString()) >= (-1L)* Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        if(!isNegative && Long.parseLong(a.toString())>=Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return isNegative ? (-1)*Integer.parseInt(a.toString()) : Integer.parseInt(a.toString());
    }
}