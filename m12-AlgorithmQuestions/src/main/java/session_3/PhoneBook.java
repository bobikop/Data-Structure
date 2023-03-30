package session_3;

public class PhoneBook {
    Node head;
    Node tail;
    int size;
    public PhoneBook() {
        this.tail=this.head=null;
        this.size=0;
    }
    boolean isEmpty(){
        return head==null;
    }
    void insert(String name, String lastName, String email, String phoneNumber) {
        // create a new node with data value
        Node node = new Node(name, lastName, email, phoneNumber);
        // check if empty

        if (isEmpty()) {
            head = tail = node;
        } else { // add element to last position
            tail.next = node;
            tail = node;
        }
        //increase size;
        size++;
    }

    void print() {
        if (isEmpty()) System.out.println("Phonebook is empty");
        else {
            Node current = head;
            while (current != null) {
                System.out.println("First name: " + current.name + " , Last Name: " + current.lastName);
                current = current.next;
            }
        }
    }

    int size(){ return this.size;}
    void deleteByEmail(String email){
        // check if empty
        if (isEmpty()) System.out.println("List is empty");
        // assign prev and current with the head
        Node prev=head;
        Node current=head;

        // iterate to the end to find a match
        while (current!=null){
            if(current.email.equals(email)) { // there is match with email
                // handle 3 edge cases
                // case 1: head
                if (current==head){
                    head=current.next;
                    current.next=null;
                }
                // case 2 : tail
                else if (current==tail) {
                    tail=prev;
                    prev.next=null;
                }
                // case 3 : Middle
                else {
                    prev.next=current.next;
                    current.next=null;
                }
                // decrease the size of phonebook
                size--;

            }
        }
    }
    void sortByName(){
        Node current1=head;
        if (current1==tail) return;
        Node current2=head.next;
        boolean swap=true;
        while(swap){
            swap=false;
            current1=head;
            current2=head.next;
            while(current1!=null && current2!=null) {
                if(current1.name.compareToIgnoreCase(current2.name)>0) {
                    swapData(current1, current2);
                    swap=true;
                }
                current1=current1.next;
                current2=current2.next;
            }
        }// end while
    }//end sortByName
    void swapData(Node node1, Node node2){
        Node temp=new Node(node2.name,node2.lastName,node2.email,node2.phoneNumber);
        node2.name=node1.name;
        node2.lastName=node1.lastName;
        node2.email=node1.email;
        node2.phoneNumber=node1.phoneNumber;

        node1.name =temp.name;
        node1.lastName=temp.lastName;
        node1.email=temp.email;
        node1.phoneNumber=temp.phoneNumber;


    }

    void removeDuplicatesFromPhonebook() {
        Node current = head;
        while (current != null) {
            Node nextDistinctNode = current.next;
            while (nextDistinctNode != null && nextDistinctNode.email == current.email){
                nextDistinctNode = nextDistinctNode.next;
            }
            current.next = nextDistinctNode;
            current = nextDistinctNode;
        }
    }
}