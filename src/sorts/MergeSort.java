package sorts;

public class MergeSort {

    /**
     * Performs merge sort on a given array.
     * @param numberArray The array of numbers to be sorted.
     */
    public void sort(int numberArray[]) {

        // determines our right and left indexes
        int left = 0;
        int right = numberArray.length - 1;

        // runs our private sort function
        sort(numberArray, left, right);

    }

    /**
     * The private call to our sort function. Note that this call is recursive. Merge sort will continue to split
     * and move downwards until smallest possible arrays have been created. Then, data will be sorted and merged
     * all the way back up.
     * @param masterArray The array to be sorted.
     * @param left Pointer of the left-most item to be sorted.
     * @param right Pointer of the right-most item to be sorted.
     */
    private void sort(int masterArray[], int left, int right) {
        if (left < right) { // If there are at least two items in the array

            // determine a middle index
            int middle = (left + right) / 2;

            // Sort first and second halves. Note that this call is recursive!
            sort(masterArray, left, middle);
            sort(masterArray, middle + 1, right);

            // Merge the sorted halves. Because this function is called last, note that the merge will not take place
            // until ALL the sorting has taken place.
            merge(masterArray, left, middle, right);

        }

    }

    /**
     * Merges two side by side individually sorted sections of an array into the same sorted section (singular).
     * This function is the heart and sole of MergeSort. While a master function invokes it and it's recursion,
     * this function very much does all of the work.
     * @param masterArray A reference to the original array that is being sorted. Note that merge will not be sorting
     *                    the whole array on one pass, only merging two already sorted sections.
     * @param left The left most item in the array to be sorted.
     * @param middle A middle point separating the right most index of the first part and the left most index of the
     *               second part. Generally this falls exactly halfway or halfway - .5;
     * @param right The right most item in the array to be sorted.
     */
    private void merge(int masterArray[], int left, int middle, int right) {

        // find the size of the two sub-arrays we are merging
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;


        // create two temporary arrays with the sizes we just determined
        int tempLeft[] = new int [sizeLeft];
        int tempRight[] = new int [sizeRight];

        // copy data to our temporary arrays
        for (int i = 0; i < sizeLeft; ++i) {
            tempLeft[i] = masterArray[left + i];
        }
        for (int j = 0; j < sizeRight; ++j) {
            tempRight[j] = masterArray[middle + 1 + j];
        }

        /* Merge into Master Array */

        // initial indexes of our temporary arrays
        int l = 0, r = 0;

        // index of our master array, set to the furthest left position
        int i = left;

        // merges our two temporary lists back into the master array
        while (l < sizeLeft && r < sizeRight) { // while still items left in temporary lists

            // add items from sorted temporary arrays to master array in correct order
            if (tempLeft[l] <= tempRight[r]) {   // if first unplaced item in temporary left array is smaller or equal to
                                                 // note that the equals is important. It makes this a stable sort.
                // place left item in master array
                masterArray[i] = tempLeft[l];

                // increment left pointer
                l++;
            }
            else {  // if first unplaced item in temporary right array is smaller

                // place right item in master array
                masterArray[i] = tempRight[r];

                // increment right pointer
                r++;
            }

            // increment master array pointer
            i++;
        }

        // copy any elements remaining in the temporary left array
        while (l < sizeLeft) {
            masterArray[i] = tempLeft[l];   // place item into master
            i++;    // increment master index
            l++;    // increment left index
        }

        // copy any elements remaining in the temporary right array
        while (r < sizeRight) {
            masterArray[i] = tempRight[r];   // place item into master
            i++;    // increment master index
            r++;    // increment left index
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

    public static void main(String[] args) {

        int numbers[] = {6, 3, 19, 12, 5, 13, 2, 1, 1, 782, 18, 54, 19, 72};

        MergeSort object = new MergeSort();

        object.printNumberArray(numbers);
        object.sort(numbers);
        object.printNumberArray(numbers);

    }
}
