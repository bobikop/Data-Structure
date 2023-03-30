package session_3;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookApp {
    public static void main(String[] args) {
        PhoneBook phoneBook=new PhoneBook();

        phoneBook.insert("ca","b","ba@g", "1");
        phoneBook.insert("ba","b","ab@g", "1");
        phoneBook.insert("aa","b","aa@g", "1");
        phoneBook.insert("ab","b","aa@g", "1");
        phoneBook.sortByName();
        phoneBook.print();
    }
}
