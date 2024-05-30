package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        doubleIt(head);
    }

    public ListNode doubleIt(ListNode head) {
        Pair<Integer, ListNode> result = func(head);
        if (result.getKey() != 0) {
            ListNode newHead = new ListNode(result.getKey());
            newHead.next = result.getValue();
            return newHead;
        }
        return result.getValue();
    }

    private Pair<Integer, ListNode> func(ListNode head) {
        int a = head.val * 2;
        if (head.next != null) {
            Pair<Integer, ListNode> nextResult = func(head.next);
            a += nextResult.getKey();
        }
        head.val = a % 10;
        return new Pair<>(a / 10, head);
    }
}