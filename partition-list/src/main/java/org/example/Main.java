package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public ListNode partition(ListNode head, int x) {
        List<Integer> smallestValues = new ArrayList<>();
        List<Integer> biggestValues = new ArrayList<>();
        while (head != null) {
            if(head.val < x) {
                smallestValues.add(head.val);
            } else {
                biggestValues.add(head.val);
            }

            head = head.next;
        }

        List<Integer> values = new ArrayList<>(smallestValues);
        values.addAll(biggestValues);

        head = new ListNode();
        ListNode temp = head;

        for (Integer value : values) {
             temp.next = new ListNode(value);
             temp = temp.next;
        }

        head = head.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}