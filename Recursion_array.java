import java.util.ArrayList;

public class Recursion_array {

    // CHECK IF ARRAY IS SORTED OR NOT ??

    public static boolean sorted(int[] arr, int index) {
        // WHEN WE REACH THE END OF ARRAY >> NO FURTHER SORTING
        if (index == arr.length - 1) {
            return true;
        }
        // COMPARE 2 ELEMENTS AND CHECK FOR THE OTHER ELEMENTS OF ARRAY
        // IF EVERY ELEMENT IS CORRECTLY PLACED >> RESULT IS TRUE
        // OTHERWISE FALSE
        return (arr[index] < arr[index + 1] && sorted(arr, index + 1));
    }

    // LINEAR SEARCH USING RECURSION
    // RETURN INDEX VALUE
    public static int search(int[] arr, int target, int index) {
        // WHEN INDEX EQUAL LENGTH OF ARRAY >> ELEMENT DOES NOT EXIST IN ARRAY
        if (index == arr.length) {
            return -1;
        }
        // IF TARGET FOUND >> RETURN THE INDEX
        if (arr[index] == target) {
            return index;
        }
        // ELSE SEARCH IN REST OF THE ARRAY
        return search(arr, target, index + 1);
    }

    // FINDING ALL INDEXES OF THE TARGET

    // CREATING STATIC ARRAYLIST FOR STORING INDEX
    static ArrayList<Integer> list = new ArrayList<>();

    public static ArrayList findAll(int[] arr, int target, int index) {

        if (index == arr.length) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return findAll(arr, target, index + 1);
    }

    // FINDING ALL INDEXES OF THE TARGET WITHOUT CREATING STATIC ARRAYLIST
    // PASS ARRAYLIST IN ARGUMENTS
    public static ArrayList findAllTARGET(int[] arr, int target, int index, ArrayList<Integer> l) {

        if (index == arr.length) {
            return l;
        }
        if (arr[index] == target) {
            l.add(index);
        }
        return findAllTARGET(arr, target, index + 1, l);
    }

    // FINDING ALL INDEXES OF THE TARGET WIHTOUT TAKING EXTERNAL LIST
    public static ArrayList<Integer> findAllIndexes(int[] arr, int target, int index) {
        ArrayList<Integer> li = new ArrayList<>();
        if (index == arr.length) {
            return li;
        }
        if (arr[index] == target) {
            li.add(index);
        }

        // ADDING RESULTS OF ALL THE CALLS BECAUSE EVRYTIME NEW LIST IS CREATED
        ArrayList<Integer> ansFromBelowCalls = findAllIndexes(arr, target, index + 1);
        // ANSWERS FROM ALL PREVIOUS CALLS ARE ADDED TO LIST
        li.addAll(ansFromBelowCalls);
        return li;
    }

    // FIND TARGET IN ROTATED ARRAY
    public static int findInRotatedArray(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int m = start + (end - start) / 2;
        if (arr[m] == target) {
            return m;
        }
        if (arr[start] <= arr[m]) {
            if (target >= arr[start] && target <= arr[m]) {
                return findInRotatedArray(arr, target, start, m - 1);
            } else {
                return findInRotatedArray(arr, target, m + 1, end);
            }
        }
        if (target >= arr[m] && target <= arr[end]) {
            return findInRotatedArray(arr, target, m + 1, end);
        }
        return findInRotatedArray(arr, target, start, m - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 4, 8, 9, 4, 12 };
        System.out.println("Is Array sorted >> " + sorted(arr, 0));
        System.out.println(search(arr, 11, 0));
        System.out.println(findAll(arr, 4, 0));
        ArrayList<Integer> l = new ArrayList<>();
        System.out.println(findAllTARGET(arr, 4, 0, l));
        System.out.println(findAllIndexes(arr, 4, 0));
        int[] rArr = { 5, 6, 7, 8, 9, 1, 2, 3 };
        System.out.println(findInRotatedArray(rArr, 10, 0, rArr.length - 1));
    }
}
