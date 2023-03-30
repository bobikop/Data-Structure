package session_2;

public class Session_2_MergeSortedArray {
    public static void main(String[] args) {

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Ptr1 for first array Ptr2 for the second array .
        int ptr1 = m - 1;
        int ptr2 = n - 1;

        // And move i backwards from end through the array
        // write the smallest value pointed at by p1 or p2 to nums1.
        for (int p = m + n - 1; p >= 0; p--) {
            if (ptr2 < 0) {
                break;
            }
            if (ptr1 >= 0 && nums1[ptr1] > nums2[ptr2]) {
                nums1[p] = nums1[ptr1--];
            } else {
                nums1[p] = nums2[ptr2--];
            }
        }
    }

}