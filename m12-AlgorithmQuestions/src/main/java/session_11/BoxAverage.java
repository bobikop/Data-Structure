package session_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxAverage {
    public static void main(String[] args) {
        //Integer[] array={10, 5, 9, 10, 12,10, 11};// 5,9,10,10,10,12

        ArrayList<Integer> boxes= new ArrayList<>(Arrays.asList(1,2,28,8,34,5,6));
        //boxes.add(12);boxes.add(2);boxes.add(18);
        System.out.println(boxAverage(boxes));
    }
    public static int boxAverage(ArrayList<Integer> ans) {
        int min= ans.get(0);
        int max= ans.get(0);
        for (Integer a : ans) {
            if (a>max) max=a;
            else if(a<min) min=a;
        }

        return (int) Math.ceil (((float)min+max)/2);
    }
}