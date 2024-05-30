package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (Objects.equals(c, '(') || Objects.equals(c, '{') || Objects.equals(c, '[')) {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            Character top = stack.peek();
            if (Objects.equals(top, '(') && Objects.equals(c, ')')) {
                stack.pop();
            } else if (Objects.equals(top, '{') && Objects.equals(c, '}')) {
                stack.pop();
            } else if (Objects.equals(top, '[') && Objects.equals(c, ']')) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}