package Tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

public class SunsetViews {
    public static void main(String[] args) {
        int[] buildings={3, 5, 4, 4, 3, 1, 3, 2};
        sunsetViews(buildings,"West").forEach(System.out::println);
    }
    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        Stack<Integer> stack = new Stack<>();  // first create a stack

        // this part is for east view
        int i =0;
        int step = 1;

        // this part is for west view direction
        if (direction.equalsIgnoreCase("west")){
            i = buildings.length-1;
            step = -1;
        }
        while (i >= 0 && i < buildings.length) {
            while(!stack.isEmpty() && buildings[i] >= buildings[stack.peek()]){  // to compare we need buildings array with peek of the stack
                stack.pop();
            }
            stack.push(i);
            i+=step;

        }
         // now I have a stack with the building index that can see the sun
        if(direction.equalsIgnoreCase("west")) Collections.reverse(stack);
        return new ArrayList<Integer>(stack);
    }
}