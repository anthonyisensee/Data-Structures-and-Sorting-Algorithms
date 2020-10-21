package sorts;

import java.util.Random;

public class QuickSort {

    /**
     * Function to sort an array of numbers using quick sort.
     *
     * Quicksort is a divide and conquer algorithm that places a pivot point somewhere in the array,
     * arranging smaller values to left and larger values to right of it. It then sorts these
     * Overwhelming average case is O(n log n).
     * Uncommon worst case is O(n^2)
     * Best case is O(n lg n)
     *
     * Note that this is an unstable sort. Sorting [... x.1, x.2, ...] (if x.1=x.2) could lead to an array where x.2
     * comes before x.1.
     *
     * @param numberArray Array of numbers to be sorted.
     */
    public void sort(int numberArray[]) {

        // sets the initial left and right indexes of the array
        int left = 0;
        int right = numberArray.length - 1;

        // calls our private sort function
        sort(numberArray, left, right);

    }

    /**
     * Private function call for our sort function.
     * @param numberArray The array to be sorted.
     * @param left The first position to sort from.
     * @param right The last position to sort to.
     */
    private void sort(int numberArray[], int left, int right) {

        // check to make sure that there are at least two elements
        if (left < right) {

            // partition array from left to right and assign the returned pivot location to a new variable called middle
            int middle = partition(numberArray, left, right);

            // recursively call sort on left and right sub arrays
            sort(numberArray, left, middle);
            sort(numberArray, middle + 1, right);  // note that you must sort the right sub-array from the indexed
                                                        // position of the pivot + 1 so that you don't try to place
                                                        // an item that is already in the right spot.

        }

    }

    /**
     * @param numberArray
     * @param left
     * @param right
     * @return The index of the placed pivot item.
     */
    private int partition(int numberArray[], int left, int right) {

        // sets the pivot point at the first item in the array (or sub-array)
        int pivot = numberArray[left];
        int i = left;
        int j = right;

        // swap values larger than pivot on left with values smaller than pivot on right
        while (i < j) { // while i and j have not crossed over each other

            // increase i until a value is found that is larger than the pivot
            while (numberArray[i] <= pivot) {   // while item in front of list is smaller than pivot
                i++;
            }

            // decrease j until a value is found that is smaller than the pivot
            while (numberArray[j] >= pivot && j >= i) {
                j--;
            }

            // if pointers have not crossed over each other
            if (i < j) {

                // swap the numbers at points i and j
                swap(numberArray, i, j);
            }

        }

        // finally, when i and j have crossed over each other, swap the pivot with the item at j
        swap(numberArray, left, j);

        // return j, the beginning of a new partition
        return j;

    }

    /**
     * Swaps two values in an array.
     * @param numberArray The array the swap is taking place inside of.
     * @param index1 The index of an item to be swapped.
     * @param index2 The index of an item to be swapped.
     */
    private void swap(int numberArray[], int index1, int index2) {

        // set item at index 1 to a temporary value
        int temp = numberArray[index1];
        // swap the item from index 2 to index 1
        numberArray[index1] = numberArray[index2];
        // place the temporary value to index 2
        numberArray[index2] = temp;
        // swap is complete

    }

    /**
     * Print an array of numbers.
     * @param numberArray The array of numbers to be printed.
     */
    public void printNumberArray(int numberArray[]) {

        for (int i = 0; i < numberArray.length; i++) {
            System.out.print(numberArray[i] + " ");
        }
        System.out.println();

    }

    public static void main(String args[]) {

        // array of numbers to sort
        int n[] = {10, 16, 8, 12, 15, 6, 3, 9, 5};
        //int n[] = {0, 0, 0, 0, 0};
        // TODO: Fix bug that causes an array full of the same number to cause a crash.
        int x[];

        QuickSort object = new QuickSort();
        object.printNumberArray(n);
        object.sort(n);
        object.printNumberArray(n);

        x = new int[20];

        // create instance of Random class
        Random rand = new Random();


        for (int i = x.length-1; i < x.length; i++) {

            // Generate random integers in range 0 to 999
            x[i] = rand.nextInt(1000);
        }

        System.out.println("Generated " + x.length + " random numbers.");

        object.printNumberArray(x);

        //object.sort(x);


    }
}
