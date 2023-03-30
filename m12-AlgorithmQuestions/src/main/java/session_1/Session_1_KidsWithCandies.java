package session_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Session_1_KidsWithCandies {
    public static void main(String[] args) {
      int[] candies= {2,3,5,1,3};
        System.out.println(kidsWithCandies(candies, 3).toString());

    }

        public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result=new ArrayList<>();
        int max= Arrays.stream(candies).max().getAsInt();
            for (int candy : candies) {
                result.add(candy+extraCandies>=max);
            }
        return result;
        }



}