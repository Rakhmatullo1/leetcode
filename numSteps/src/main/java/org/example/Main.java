package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println(numSteps("100010001111001110010111011000010000011100101010000010001100110100101011011001100011111110001110111011011100110111101101001101110110010000000110111100000010001000000011010001010011111110100001111110101111110101010001010101111101101110110011100010111000110001100000100001010000101011000101"));
    }

    public static int numSteps(String s) {
        Integer c = 0;
        c = calcSteps(s, c);
        return c;
    }

    public  static int calcSteps(String s, Integer c) {
        int num = getNum(s);

        if(num==1) {
            return c;
        }

        c++;

        if(s.charAt(s.length()-1)=='1') {
            s = addBinary(s, "1");
            return  calcSteps(s,c);
        } else {

            s = "0"+ s.substring(0, s.length()-1);
            return  calcSteps(s, c);
        }
    }

    public static int getNum(String s) {
        try {
            return Integer.parseInt(s, 2);
        } catch (Exception ex) {
            return -1;
        }
    }

    public static String addBinary(String x, String y)
    {
        int i = x.length() - 1, j = y.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += x.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += y.charAt(j) - '0';
            }
            if (sum == 0 || sum == 1) {
                result.append(sum);
                carry = 0;
            }
            else if (sum == 2) {
                result.append("0");
                carry = 1;
            }
            else {
                result.append("1");
                carry = 1;
            }
            i--;
            j--;
        }
        if (carry == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }
}