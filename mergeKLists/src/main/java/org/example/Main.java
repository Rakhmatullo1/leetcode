package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ListNode tailOne = new ListNode(5);
        ListNode secondOne =  new ListNode(4, tailOne);
        ListNode headOne = new ListNode(1, secondOne);

        ListNode tail = new ListNode(4);
        ListNode second =  new ListNode(3, tail);
        ListNode head = new ListNode(1, second);


        mergeKLists(new ListNode[]{headOne, head});
    }
    public  static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode result = head;
        List<Integer> values = new ArrayList<>();
        for(int i=0; i<lists.length; i++) {
            ListNode temp = lists[i];
            while(!Objects.isNull(temp)) {
                values.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(values);

        for(int i=0; i<values.size(); i++) {
            head.next = new ListNode(values.get(i));
            head = head.next;
        }

        result = result.next;

        return result;
    }
}