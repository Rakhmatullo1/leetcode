package org.example;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ListNode tail = new ListNode(8);
        ListNode fth = new ListNode(3,tail);
        ListNode third = new ListNode(13, fth);
        ListNode second = new ListNode(2, third);
        ListNode head = new ListNode(5, second);

        removeNodes(head);

    }

    public static ListNode removeNodes(ListNode head) {
        head = reverse(head);
        ListNode prev = head;
        ListNode temp = head;

        int maxVal = 0;

        while(!Objects.isNull(temp)) {
            if(maxVal< temp.val) {
                maxVal = temp.val;
            } else {
                deleteNode(prev, temp.val);
            }
            temp = temp.next;
        }

        return reverse(prev);
    }

    private static void deleteNode(ListNode head, int val) {
        ListNode temp = head;
        ListNode prev= head;

        while (!Objects.isNull(temp) && temp.val !=val)
        {
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;

    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}
