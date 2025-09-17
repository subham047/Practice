package com.subham.Practice.Others.LinkedList;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);

        System.out.println("middle = " + findMiddleOfLinkedList(listNode).val);
    }

    public static ListNode findMiddleOfLinkedList(ListNode listNode) {
        if (listNode == null) {
            return null;
        }

        ListNode slow = listNode;
        ListNode fast = listNode;

//        for odd length
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }

//        for even length - There will be two middles in even legth linkedlist
//        first middle
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

//        second middle
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
        return slow;

    }
}
