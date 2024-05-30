package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ListNode tail = new ListNode(5);
        ListNode fth = new ListNode(4, tail);
        ListNode trd = new ListNode(3, fth);
        ListNode snd = new ListNode(2, trd);
        ListNode head = new ListNode(1, snd);
        reverseKGroup(head, 0);
    }

    public  static ListNode reverseKGroup(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();

        while (!Objects.isNull(head)) {
            list.add(head.val);
            head = head.next;
        }

        List
        for(int i=0; i<list.size(); i=i+k) {
            List<Integer> temp = list.subList(i, i+k-1);
            Collections.reverse(list.subList(i, i+k-1));
        }

        return head;
    }
}