package sorts;

public class InsertionSort {

    /**
     * Function to sort an array of numbers using insertion sort.
     * Worst case is O(n^2), a backwards array.
     * Best case is O(n), an already sorted array.
     * @param numberArray An array of numbers.
     */
    void sort(int numberArray[]) {

        // prints the array we will begin with
        System.out.println("Beginning Array:");
        printNumberArray(numberArray);
        System.out.println("Sorting Process:");


        // n is the length of our array and the number of items to be sorted
        int n = numberArray.length;

        // begins the outer for loop of insertion sort
        for (int i = 1; i < n; ++i) {   // for every item in the array

            // set our key, the number we will be sorting.
            int key = numberArray[i];

            // set the variable for our second loop, a variable that checks backwards from i
            int j = i - 1;

            // this loop will place the value in the correct place in the array
            while (j >= 0 && numberArray[j] > key)  {
                    // while j still has places to check and the value it is checking is larger than
                    // the value we are trying to sort/place. The numbers are switched at each step until
                    // the conditions are no longer met.
                numberArray[j + 1] = numberArray[j];
                j = j - 1;
            }
            // as our final step, place our key in the correct position
            numberArray[j+1] = key;

            // print the array so we can see change as we go
            printNumberArray(numberArray);
        }
        System.out.println("Final Array:");
        printNumberArray(numberArray);

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
        int n[] = {6, 5, 4, 3, 2, 1};

        InsertionSort object = new InsertionSort();
        object.printNumberArray(n);
        object.sort(n);
    }

}

