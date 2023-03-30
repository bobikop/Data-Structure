package session_3;

public class Node {
    String name;
    String lastName;
    String email;
    String phoneNumber;
    Node next;

    public Node(String name, String lastName, String email, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}