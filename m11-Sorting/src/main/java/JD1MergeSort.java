public class JD1MergeSort {
    public static void mergeSort(int[] array){

        if(array.length < 2) return; // if we have one element in array we can stop
        int mid = array.length/2;
        int[] leftArray = new int[mid];

        for (int i = 0; i < mid; i++) leftArray[i] = array[i];

        int[] rightArray = new int[array.length - mid];
        for (int i = mid; i< array.length; i++) rightArray[i-mid] = array[i];

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray , rightArray, array);

    }








    // how to merge two sorted arrays
    public  static void merge(int[] left, int[] right, int[] result){
   // we need three pointers, one for each array
        int i = 0;
        int j = 0;
        int k = 0;

   // first will start to compare left array with right array
        while (i < left.length && j < right.length){
            if(left[i] <= right[j])
                result[k++] = left[i++];
            else result[k++] = right[j++];
        }
        if (i < left.length) result[k++] = left[i++];
        if (j < left.length) result[k++] = right[j++];

    }

}