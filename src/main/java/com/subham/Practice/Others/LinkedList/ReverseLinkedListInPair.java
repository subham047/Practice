package com.subham.Practice.Others.LinkedList;

public class ReverseLinkedListInPair {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);

        System.out.println("Before getting reversed --> ");
        printList(listNode);
        ListNode resultLinkedList = reverseLinkedList(listNode);


        System.out.println();
        System.out.println("After getting reversed --> ");
        printList(resultLinkedList);
    }

    // Function to reverse in pairs
    public static ListNode reverseLinkedList(ListNode head) {
        // Base condition: if empty list or only one node
//            if (head == null || head.next == null) {
//                return head;
//            }

        ListNode prev = head;
        ListNode curr = head.next;

        // new head will be the 2nd node
        head = curr;

        while (true) {
            ListNode next = curr.next;   // save next
            curr.next = prev;        // reverse link

            // if no next pair left
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }

            // connect previous node with next pair's 2nd node
            prev.next = next.next;

            // move pointers
            prev = next;
            curr = prev.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
