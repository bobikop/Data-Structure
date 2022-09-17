import java.util.ArrayList;

public class MySinglyLinkedList {
    Node head;
    Node tail;
    int size;

    boolean isEmpty() {
        return head == null;
    }

    //--------------------------------------------------------------------------//

    void add(int data) {
        // create a new node object from data
        Node node = new Node(data);

        if (isEmpty()) { // if the list is empty
            head = tail = node;
            size++;
        } else { // if there are elements in list
            tail.next = node;
            tail = node;
            size++;
        }

    }

    //--------------------------------------------------------------------------//

    void addFirst(int data){
        Node node1 = new Node(data);

        if(isEmpty()){
            head = tail = node1;
            size++;
        }else{
            node1.next = head;
            head = node1;
            size++;
        }
    }

    //--------------------------------------------------------------------------//

    void deleteById(int id){
        // check if empty
        if(isEmpty()) System.out.println("List is empty!!!");
        // assign prev and current with the head

        Node prev=head;
        Node current=head;
        while(current!=null){
            if(current.id==id){// there is a match
                //case 1: head
                if(current==head){
                    head=current.next;
                    current.next=null;
                }
                // case 2 : tail
                else if(current==tail){
                    tail=prev;
                    prev.next=null;//Ex -Tail will be eligible for Garbage Collection
                }
                // case 3 : middle
                else{
                    prev.next=current.next;
                    current.next=null;// Current will be eligible for Garbage Collection
                }
                // after deletion
                size--;
            }
            // move forward on the elements of the list
            prev=current;
            current=current.next;

        }

    }

    //--------------------------------------------------------------------------//
    int indexOf(int id){
        if (isEmpty()) return -1;
        int pos=0;
        // iterate through the list
        Node current=head;// set my current with the starting element;
        while(current!=null){
            if(current.id==id) return pos;
            pos++;
            current=current.next;
        }
        return -1;
    }

    //--------------------------------------------------------------------------//
    void printNodes(){
        Node current=head;
        while(current!=null){
            if (current.next==null) System.out.println(current.id+"=> null");
            else {
            System.out.print(current.id+"=> ");
            }
            current=current.next;
        }
  }

    //--------------------------------------------------------------------------//


    void findKthFromLast(int K){

        int length = 0; // here we initialize the length of the Linked list
        Node temporary = head; // temporary note to track

        // 1) count the number of nodes in Linked List
        while(temporary != null){
            temporary = temporary.next;
            length++; // number of nodes
        }
        // check if value of K is not more than length of the linked list

        if(length < K) return;
        temporary = head;

        // 2) get the (len-N+1)th node from the beginning

        for (int i = 1; i < length - K + 1; i++)
            temporary = temporary.next;

        System.out.println(temporary.id);
    }


    void removeKthFromLast(int K){

       Node ptr1 = head;
       Node ptr2 = head;
       Node prev = null;

        for (int i = 0; i < K-1 ; i++) {
            ptr2=ptr2.next;

            while(ptr2.next!=null){
                prev=ptr1;
                ptr1=ptr1.next;
                ptr2=ptr2.next;

            }
            if (ptr1==head){
                head=ptr1.next;
                ptr1.next = null;
                size--;

            }else if(ptr1 == tail){
                      tail=prev;
                      prev.next=null;
                      size--;
                }else{

                prev.next=ptr1.next;
                ptr1.next=null;
                        size--;

            }

        }


    }
}