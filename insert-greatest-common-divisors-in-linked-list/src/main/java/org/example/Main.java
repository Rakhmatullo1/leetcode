package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = main.buildListNode(List.of(1000,500));
        main.insertGreatestCommonDivisors(head);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        List<Integer> result = new ArrayList<>();

        if(list.size()==1) {
            return buildListNode(list);
        }

        for(int i=0; i<list.size()-1; i++) {
            if(i==0) {
                result.add(list.get(i));
            }
            result.add(findGCD(list.get(i), list.get(i+1)));
            result.add(list.get(i+1));
        }

        return buildListNode(result);
    }

    public int findGCD(int x, int y) {
        int  gcd = 1;
        for (int i = 1; i <= x && i <= y; i++) {
            if (x % i == 0 && y % i == 0)
                gcd = i;
        }
        return gcd;
    }

    private ListNode buildListNode(List<Integer> list) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (Integer i : list) {
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