package session_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.toList;

public class LetterCandles {
    public static void main(String[] args) {
        System.out.println(letterCandlesCost(6, 3, "bacbcc"));
    }
    public static int letterCandlesCost(int letterCount, int m,String str){
        // create a map : this will cost me space complexity O(n)
        Map<Character,Integer> map= new TreeMap<>();
        int count;
        int cost=0;
        // count the frequency of chars
        for(Character ch:str.toCharArray()){
            if(map.containsKey(ch)) {
                count=map.get(ch);
                map.put(ch, count+1);
            }
            else map.put(ch, 1);
        }// O(n)
        //ArrayList<Integer> letters= (ArrayList<Integer>) map.values().stream().sorted ((o1, o2)->o2.compareTo(o1)).collect(toList());

        int index=0;
        List<Integer> letterFreq= map.values().stream().sorted ((o1, o2)->o2.compareTo(o1)).collect(toList());
        // O(nlogn) Constant time complexity O(1)

        // Cost is reduced here!
        while(m>0 && index<letterFreq.size()-1){
            if (letterFreq.get(index)>=letterFreq.get(index+1)) {
                letterFreq.set(index,letterFreq.get(index)-1);
                m--;
            } else index++;
        } // O(m=26 at most) O(1)

        for (Integer num : letterFreq) {
            cost+=num*num;
        } // O(m<=26)
        return cost; // O(n) -> O(1)
    } // O(n) + O(nlogn)+ O(n) O(n) -> O(nlogn) O(nlogn)
}