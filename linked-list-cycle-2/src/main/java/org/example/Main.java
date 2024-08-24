package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count =0;
        int loopSize = 0;

        while(slow!=null && fast != null && fast.next != null) {
            if(count>=1){
                count++;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                count = 1;
                if(count!=1 && count !=0){
                    loopSize = count;
                    break;
                }
            }
        }

        System.out.println(loopSize);
        return null;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}