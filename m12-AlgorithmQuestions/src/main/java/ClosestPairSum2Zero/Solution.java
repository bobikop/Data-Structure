package ClosestPairSum2Zero;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
 int[] array={7,-9,15,-2};
        System.out.println(closestToZero(array));
    }
    public static int closestToZero(int[] array){
        Arrays.sort(array);
        int leftPointer=0;
        int rightPointer=array.length-1;
        int res=Integer.MAX_VALUE;
        while(leftPointer<rightPointer){
            int difference=array[rightPointer]+array[leftPointer];
            res=Math.min(res, difference);
            if (difference>0) rightPointer--;
            else if (difference<0)leftPointer++;
            else return 0;
        }

        return res;
    }
}