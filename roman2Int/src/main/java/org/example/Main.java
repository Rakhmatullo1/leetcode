package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println(roman2int("MCMXCIV"));
    }

    public static int roman2int(String s){
        Map<String, Integer> map = Map.of("I",1,"V",5,"X",10, "L", 50, "C", 100, "D", 500, "M", 1000);

        List<String> parts = Arrays.stream(s.split("")).toList();

        long sum =0;

        for(int i=0;i<parts.size(); i++ ) {
            if(i!=parts.size()-1){
                if(Objects.equals(parts.get(i), "I") && Objects.equals(parts.get(i+1), "V")) {
                    sum = sum + 4;
                    i++;
                } else if (Objects.equals(parts.get(i), "I") && Objects.equals(parts.get(i+1), "X")) {
                    sum = sum + 9;
                    i++;
                } else if (Objects.equals(parts.get(i), "X") && Objects.equals(parts.get(i+1), "L")) {
                    sum = sum + 40;
                    i++;
                } else if (Objects.equals(parts.get(i), "X") && Objects.equals(parts.get(i+1), "C")) {
                    sum = sum + 90;
                    i++;
                } else if (Objects.equals(parts.get(i), "C") && Objects.equals(parts.get(i+1), "D")) {
                    sum = sum + 400;
                    i++;
                } else if (Objects.equals(parts.get(i), "C") && Objects.equals(parts.get(i+1), "M")) {
                    sum = sum + 900;
                    i++;
                } else {
                    sum = sum + map.get(parts.get(i));

                }
            } else {
                sum = sum + map.get(parts.get(i));
            }
        }

        return (int) sum;
    }
}