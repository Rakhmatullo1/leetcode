package org.example;

import java.util.Objects;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        ListNode tail = new ListNode(4);
        ListNode tNode = new ListNode(3, tail);
        ListNode sNode = new ListNode(2, tNode);
        ListNode head = new ListNode(1, sNode);

        head = swapPairs(head);
        System.out.println(head);
    }

    public static ListNode swapPairs(ListNode head) {
        int length = 0;
        int[] values = new int[]{};
        ListNode temp  = head;

        while (!Objects.isNull(temp)){
            length++;
            temp = temp.next;
        }
        values = new int[length];

        for(int i=0; i<values.length; i++) {
            values[i] = head.val;
            head = head.next;
        }



        for(int i=0; i<length/2; i++) {
            int tempInt = values[2*i];
            values[2*i] = values [ 2*i+1];
            values[2*i+1] = tempInt;
        }

        return convert(values);
    }

    private static ListNode convert(int[] values) {
        ListNode head = new ListNode();
        ListNode tempOne = head;

        for(Integer i : values) {
            tempOne.next = new ListNode(i);
            tempOne = tempOne.next;
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
