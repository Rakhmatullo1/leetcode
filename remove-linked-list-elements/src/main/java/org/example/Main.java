package org.example;

import java.util.List;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = main.buildLinkedList(List.of(7,7,7,7));
        ListNode real = main.removeElements(head, 7);

        Integer a = 1;
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode();
        ListNode temp = result;

        while (head != null) {
            if(head.val == val){
                head = head.next;
                continue;
            }
            temp.next = new ListNode(head.val);
            temp = temp.next;
            head = head.next;
        }

        result = result.next;
        return result;
    }

    public ListNode buildLinkedList(List<Integer> integerList) {
        ListNode head = new ListNode();
        ListNode temp = head;

        for(int i: integerList) {
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