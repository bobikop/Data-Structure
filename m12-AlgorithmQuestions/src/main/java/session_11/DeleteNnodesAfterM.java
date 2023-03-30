package session_11;

public class DeleteNnodesAfterM {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        ListNode n11 = new ListNode(11);
        ListNode n12 = new ListNode(12);
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;
        n5.next=n6;n6.next=n7;n7.next=n8;n8.next=n9;
        n9.next=n10;n10.next=n11;n11.next=n12;

        deleteNodes(n1, 2, 1);
        ListNode current=n1;
        while(current!=null){
            System.out.print(current.val+" -> ");
            current=current.next;
        }
        System.out.print("null");
    }
    public static ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode currentNode = head;
        ListNode lastMNode = head;
        while (currentNode != null) {
            // initialize mCount to m and nCount to n
            int mCount = m, nCount = n;
            // traverse m nodes
            while (currentNode != null && mCount != 0) {
                lastMNode = currentNode;
                currentNode = currentNode.next;
                mCount--;
            }
            // Skip n nodes //
            while (currentNode != null && nCount != 0) {
                currentNode = currentNode.next;
                nCount--;
            }
            // delete n nodes
            lastMNode.next = currentNode;
        }
        return head;
    }
}