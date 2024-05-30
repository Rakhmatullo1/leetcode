package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        ListNode tail = new ListNode(8);
//        ListNode fth = new ListNode(3,tail);
        ListNode third = new ListNode(2);
        ListNode second = new ListNode(1, third);
        ListNode head = new ListNode(1, second);

        deleteDuplicates(head);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        List<Integer> integerList = new ArrayList<>();
        ListNode temp = new ListNode();
        ListNode headOne = temp;

        while(!Objects.isNull(head)) {
            if(!integerList.contains(head.val)) {
                headOne.next = new ListNode(head.val);
                headOne = headOne.next;
            }
            head = head.next;
        }
        temp = temp.next;

        return temp;
    }
}