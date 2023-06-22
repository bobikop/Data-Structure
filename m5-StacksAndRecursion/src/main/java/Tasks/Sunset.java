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

/*
*
* • Main stack operations
- void push(int data): Inserts data onto stack.
- int pop(): Removes and returns the last inserted element from the stack.

• Auxiliary stack operations
- Top(): Returns the last inserted element without removing it. (Peek())
- int Size(): Returns the number of elements stored in the stack.
- int IsEmpty(): Indicates any elements are stored in the stack or not.
- int IsFull(): Indicates the stack is full or not.

• Can be implemented using Arrays or Linked Lists (stack is an Abstract Data Type-ADT)*/
