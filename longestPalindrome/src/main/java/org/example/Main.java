package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (chars.containsKey(s.charAt(i))) {
                chars.put(s.charAt(i), chars.get(s.charAt(i)) + 1);
            } else {
                chars.put(s.charAt(i), 1);
            }
        }

        int oddChars = 0;

        for (Character key : chars.keySet()) {
            if (isOdd(chars.get(key))) {
                oddChars++;
            }
        }

        if (oddChars == 0) {
            return s.length();
        }

        if (oddChars == 1) {
            return s.length();
        }

        int size = s.length();

        List<Integer> sizes = chars.values().stream().sorted().filter(this::isOdd).collect(Collectors.toList());
        Collections.reverse(sizes);
        int len = sizes.size() - 1;
        while (oddChars != 1) {
            size = size - 1;
            len--;
            oddChars--;
        }

        return size;
    }

    private boolean isOdd(int num) {
        return num % 2 != 0;
    }
}