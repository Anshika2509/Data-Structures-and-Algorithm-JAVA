public class RecurionBubbleSort {
    public static int[] sort(int[] arr, int row, int col) {
        // WHEN WE HAVE MADE ALL COMPARISIONS AND REQUIRED SWAPS -- RETURN THE ARRAY
        if (row < 1) {
            return arr;
        }

        // WHEN IN THE SAME ROW --> FOR THE SAME PASS
        if (col < row) {
            // MAKING COMPARISION
            if (arr[col] > arr[col + 1]) {
                int temp = arr[col];
                arr[col] = arr[col + 1];
                arr[col + 1] = temp;
            }
            return sort(arr, row, col + 1);
        }
        // FOR NEXT PASS
        else {
            return sort(arr, row - 1, 0);
        }

    }

    public static void main(String[] args) {

        // BUBBLE SORT IS CODED SAME AS FIRST PATTERN - INVERTED TRIANGLE.
        // GIVEN ARR = 6 2 8 1
        // 2 6 1 8
        // 2 1 6 8
        // 1 2 6 8
        // IN EACH PASS LAST ELEMENT IS FIXED. THUS ELEMENTS TO BE COMPARED DECREASE BY
        // ONE => FORM AN INVERTED TRIANGLE
        /*
         * * * *
         * * *
         * *
         *
         */

        int[] arr = { 6, 2, 8, 1 };
        System.out.println("before swap");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        arr = sort(arr, arr.length - 1, 0);
        System.out.println("\nafter swap");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
