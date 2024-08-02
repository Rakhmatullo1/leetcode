package org.example;

import java.util.*;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode listNode =  main.deleteDuplicates(main.buildList(List.of(-3,-1,0,0,0,3,3)));

    }

    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> integerList = new ArrayList<>();

        while (!Objects.isNull(head)) {
            integerList.add(head.val);
            head = head.next;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<integerList.size(); i++) {
            if(map.containsKey(integerList.get(i))){
                map.put(integerList.get(i), 2);
            }else {
                map.put(integerList.get(i), 1);
            }
        }

        List<Integer> newList = map.keySet().stream().filter(v->map.get(v)==1).toList();
        Collections.sort(newList);

        return buildList(newList);
    }

    private ListNode buildList(List<Integer> nums) {
        ListNode head = new ListNode();
        ListNode temp = head;

        for(int i=0; i<nums.size(); i++) {
            temp.next = new ListNode(nums.get(i));
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