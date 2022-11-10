package Tasks;

public class Sunset {


    // Returns count buildings that can see sunlight
    static int countBuildings(int arr[], int n)
    {
        // Initialize result  (Note that first building
        // always sees sunlight)
        int count = 1;

        // Start traversing element
        int curr_max = arr[0];
        for (int i = 1; i < n; i++) {

            // If curr_element is maximum
            // or current element
            // is equal, update maximum and increment count
            if (arr[i] > curr_max || arr[i] == curr_max) {
                count++;
                curr_max = arr[i];
            }
        }

        return count;
    }

    // Driver method
    public static void main(String[] args)
    {
        int arr[] = { 7, 4, 8, 2, 9 };

        System.out.println(countBuildings(arr, arr.length));
    }
}
