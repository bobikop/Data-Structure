package session_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class FindGreatestNumberInaString {
    public static void main(String[] args) {
        System.out.println(greatestNumInString("h898sag1222"));
    }
    static int greatestNumInString(String str){
        int num = 0, result = 0;
        TreeMap<Integer,Integer> aa=new TreeMap<>();

        for (int i = 0; i<str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                num = num * 10 + (str.charAt(i)-'0');
            else {
                result = Math.max(result, num);
                num = 0;
            }
        }

        return Math.max(result, num);

    }
}
