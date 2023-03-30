

package Max3Numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find3Max {
    public static void main(String[] args) {
        //int[] array={10, 5, 9, 10, 12,10, 11};// 5,9,10,10,10,12
       // System.out.println(Arrays.toString(findThreeLargestNumbers(array)));
        ArrayList<Integer> boxes=new ArrayList<>();
        boxes.add(12); boxes.add(18); boxes.add(2);
        //System.out.println(boxAverage(boxes));
    }
    public static int[] findThreeLargestNumbers(int[] array) {
        int min=Integer.MIN_VALUE, mid=Integer.MIN_VALUE,max=Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {

            if(array[i]>max){
            min=mid;
            mid=max;
            max=array[i];
            } else if (array[i]>mid) {
                min=mid;
                mid=array[i];
            } else if (array[i]>min) {
                min=array[i];
            }
        }
        return new int[] {min,mid,max};

    }




}