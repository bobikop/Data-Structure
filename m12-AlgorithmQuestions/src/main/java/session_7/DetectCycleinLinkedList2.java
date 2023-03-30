package session_7;

import java.util.HashSet;
import java.util.Set;

public class DetectCycleinLinkedList2 {
    public static void main(String[] args) {
        ListNode n1=new ListNode(3);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(0);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n2;

        System.out.println(detectCycle(n1).val);
    }
    private static ListNode getIntersect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }

        return null;
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        // To find the entrance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }

    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> seenNodes = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (seenNodes.contains(node)) {
                return node;
            }
            seenNodes.add(node);
            node = node.next;
        }
        return null;
    }
}