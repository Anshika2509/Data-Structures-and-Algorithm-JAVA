public class RecursionSelectionSort {
    public static void sort(int arr[], int row, int col, int ind) {

        // WHEN ALL PASSES ARE DONE => RETURN
        if (row < 1) {
            return;
        }
        // WE TRAVERSE ARRAY UNTIL COL IS LESS THEN ROW
        if (col < row) {
            if (arr[col] > arr[ind]) {
                // WHEN ELEMENT AT COL IS MAXIMUM COL INDEX IS PASSED AS IND
                sort(arr, row, col + 1, col);
            } else {
                sort(arr, row, col + 1, ind);
            }
        } else {
            // SWAP THE LARGEST ELEMENT WITH THE LAST ELEMENT OF UNSORTED PART OF ARRAY
            int temp = arr[ind];
            arr[ind] = arr[row - 1];
            arr[row - 1] = temp;

            // CALL THE FUNCTION FOR ROW-1 AS LARGER ELEMENTS THAN ELEMENT AT ROW-1 ARE
            // AREADY FIXED.
            sort(arr, row - 1, 0, 0);

        }

    }

    public static void main(String[] args) {
        int[] arr = { 6, 2, 8, 1 };
        System.out.println("Unsorted array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        sort(arr, arr.length, 0, 0);
        System.out.println("after sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
