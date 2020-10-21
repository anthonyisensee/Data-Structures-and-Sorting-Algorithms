package sorts;

public class SelectionSort {

    /** Sorts an array of numbers using Selection Sort. */
    void sort(int numberArray[]) {

        // gather array length
        int n = numberArray.length;

        // begin our outer loop
        for (int i = 0; i < n-1; i++) {

            // find the smallest number
            int indexOfMinimum = i;
            for (int j = i + 1; j < n; j++) {
                if (numberArray[j] < numberArray[indexOfMinimum])
                    indexOfMinimum = j;
            }

            // swap the minimum element with the first element
            int temp = numberArray[indexOfMinimum];
            numberArray[indexOfMinimum] = numberArray[i];
            numberArray[i] = temp;

        }
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

        SelectionSort object = new SelectionSort();
        object.printNumberArray(n);
        object.sort(n);
        object.printNumberArray(n);

    }
}
