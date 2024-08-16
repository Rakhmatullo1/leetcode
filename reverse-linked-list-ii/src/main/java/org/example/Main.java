package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<Integer> partition = new ArrayList<>();
        List<Integer> headList = new ArrayList<>();
        List<Integer> tail = new ArrayList<>();
        int count = 1;
        while (head != null) {
            if(left<=count && count<=right){
                partition.add(head.val);
            } else if (count < left) {
                headList.add(head.val);
            } else if (count> right){
                tail.add(head.val);
            }
            count++;
            head = head.next;
        }

        List<Integer> values = new ArrayList<>(headList);
        Collections.reverse(partition);
        values.addAll(partition);
        values.addAll(tail);

        head = new ListNode();
        ListNode temp = head;

        for(Integer value : values) {
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