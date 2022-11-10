import java.util.ArrayList;

public class SinglyLinkedListApp {
    public static void main(String[] args) {
        MySinglyLinkedList myList =new MySinglyLinkedList();
        System.out.println(myList.isEmpty());

        for (int i = 0; i < 10; i++) {
            myList.add(i);
        }
        myList.printNodes();
        myList.deleteById(9);
        myList.printNodes();
        System.out.println("index of 3 :"+ myList.indexOf(3));
        System.out.println("----------------------------------------------------");


        myList.addFirst(99);
        myList.printNodes();
        myList.findKthFromLast(5);

        myList.removeKthFromLast(2);
        myList.removeKthFromLast2(2);


    }
}
