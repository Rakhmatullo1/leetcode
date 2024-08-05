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
        Main main = new Main();
        ListNode head = main.buildList(List.of(1,2,3,4,5));
        head = main.oddEvenList(head);

    }

    public ListNode oddEvenList(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head !=null) {
            nums.add(head.val);
            head = head.next;
        }

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for(int i=0; i<nums.size(); i++) {
            if(i%2==0) {
                even.add(nums.get(i));
            }else {
                odd.add(nums.get(i));
            }
        }

        even.addAll(odd);

        return buildList(even);
    }

    private ListNode buildList(List<Integer> nums) {
        ListNode head = new ListNode();
        ListNode temp = head;

        for(Integer i : nums) {
            temp.next = new ListNode(i);
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