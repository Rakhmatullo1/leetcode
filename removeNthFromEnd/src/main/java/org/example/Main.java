package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = head;
        List<Integer> integerList = new ArrayList<>();
        while (!Objects.isNull(h)) {
            integerList.add(h.val);
            h = h.next;
        }

        integerList.remove(n);

        ListNode result = head;
        ListNode temp = result;

        for(int i=0; i<integerList.size(); i++) {
            temp.next = new ListNode(integerList.get(i));
            temp = temp.next;
        }

        result = result.next;
        return result;
    }
}