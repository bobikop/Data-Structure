public class PerformanceCalculationOfSearchMethods {
    public static void main(String[] args) {
        int[] numbers = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            numbers[i] = i;
        }
        long[] linearSearchResults = linearSearch(numbers, 333333);
        System.out.println("Linear Search Results:  " + linearSearchResults[0] + " miliseconds and " + linearSearchResults[1] + " comparisons..");
    }
    public static long[] linearSearch(int[] array, int data){
        long[] result=new long[2];
        long startTime=System.currentTimeMillis();
        int comparisons=0;
        for (int i = 0; i < array.length ; i++) {
         comparisons++;
            if(array[i]==data) {
                result[0]= System.currentTimeMillis()-startTime;
                result[1]=comparisons;
                return result;
            }
        }
        return new long[2];
    }
}