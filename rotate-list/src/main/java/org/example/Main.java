package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Main main = new Main();
        ListNode head = main.buildList(List.of(1,2,3));
        ListNode rotated = main.rotateRight(head, 2000000000);
    }

    public ListNode rotateRight(ListNode head, int k) {
        List<Integer> nums = new ArrayList<>();

        while (head !=null) {
            nums.add(head.val);
            head = head.next;
        }

        if(nums.isEmpty()) {
            return null;
        }

        List<Integer> temp = new ArrayList<>();
        temp.addAll(nums);

        for(int i=0; i<k; i++) {
            int last = nums.get(nums.size()-1);
            nums.remove(nums.size()-1);
            nums.add(0, last);
            if(Objects.equals(temp, nums)) {
                k = k % (i+1);
                k++;
                i=0;
            }
        }

        return buildList(nums);
    }

    private ListNode buildList(List<Integer> arr) {
        ListNode head = new ListNode();
        ListNode temp = head;

        for(int i=0; i<arr.size(); i++) {
            temp.next = new ListNode(arr.get(i));
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