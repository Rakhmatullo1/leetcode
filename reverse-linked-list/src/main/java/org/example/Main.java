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

    public ListNode reverseList(ListNode head) {
        ListNode headOne = new ListNode();
        ListNode temp = headOne;
        List<Integer> list = new ArrayList<>();

        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        for(Integer value: list){
            temp.next = new ListNode(value);
            temp = temp.next;
        }

        headOne = headOne.next;
        return headOne;
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