package db;

import java.util.ArrayList;
import java.util.Collections;

public class BinarySearch {

    public static db_input binarySearch(ArrayList<db_input> arr_base, int x)
    {
        ArrayList<db_input> arr = SparseArray.make_sparse_dense(arr_base);
        int l = 0, r = arr.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr.get(m).index == x)
                return arr.get(m);

            // If x greater, ignore left half
            if (arr.get(m).index < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return null;
    }
}
