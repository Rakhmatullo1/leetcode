package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        boolean isNeg = false;
        if(x<0) {
            isNeg = true;
            x=x*(-1);
        }

        if(x==Integer.MIN_VALUE) {
            return  0;
        }

        String valueInString = String.valueOf(x);

        List<Integer> parts = Arrays.stream(valueInString.split("")).map(Integer::valueOf).collect(Collectors.toList());
        Collections.reverse(parts);

        int result = 0;
        for(int i=0; i<parts.size();i++) {
            result =(int) (result + parts.get(i)* Math.pow(10.0, parts.size()-i-1));
        }

        if(result == Integer.MAX_VALUE) {
            result = 0;
        }

        return  isNeg  ?   (-1)*result : result;
    }
}