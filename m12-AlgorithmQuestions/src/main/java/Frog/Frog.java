package Frog;


public class Frog {
    public static void main(String[] args) {
        int[] blocks= {5,2,3,6,7,8};
        System.out.println(solution(blocks));
    }
    static int solution(int[] blocks) {

        int distance=-1;
        for (int i = 0; i < blocks.length; i++) {
            //left jumps available from that index
            int leftIndex=i;
            while(leftIndex>1) {
                if (blocks[leftIndex]<= blocks[leftIndex-1]) leftIndex--;
                else break;
            }
            int rightIndex=i;
            while( rightIndex< blocks.length-1){
                if (blocks[rightIndex+1]>= blocks[rightIndex]) rightIndex++; else break;
            }
            distance =Math.max(distance, rightIndex-leftIndex+1);
        }
        return distance;

    }
}