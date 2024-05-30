package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ListNode tailOne = new ListNode(4);
        ListNode secondOne = new ListNode(2, tailOne);
        ListNode headOne = new ListNode(1, secondOne);

        ListNode tailTwo = new ListNode(4);
        ListNode secondTwo = new ListNode(3, tailTwo);
        ListNode headTwo = new ListNode(1, secondTwo);

        mergeTwoLists(headOne, headTwo);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> temp = new ArrayList<>();
        while(!Objects.isNull(list1)) {
            temp.add(list1.val);
            list1 = list1.next;
        }

        while(!Objects.isNull(list2)) {
            temp.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(temp);

        ListNode head = new ListNode();
        ListNode tempOne = head;

        for(Integer i : temp) {
            tempOne.next = new ListNode(i);
            tempOne = tempOne.next;
        }

        head = head.next;
        return head;
    }
}