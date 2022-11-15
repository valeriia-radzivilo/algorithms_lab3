package db;

import java.util.ArrayList;

public class BinarySort {
    static ArrayList<db_input> array_to_sort;
    static int amount = array_to_sort.size();

    BinarySort(ArrayList<db_input>array_to_sort)
    {
        BinarySort.array_to_sort = array_to_sort;
    }

    int binarySearch(int left_value, int right_value, int x)
    {
        if (right_value >= left_value) {
            int mid = left_value + (right_value - left_value) / 2;

            // If the element is present at the
            // middle itself
            if (array_to_sort.get(mid).index == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left_value subarray
            if (array_to_sort.get(mid).index > x)
                return binarySearch(left_value, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(mid + 1, right_value, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
