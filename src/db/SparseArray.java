package db;

import java.util.ArrayList;

public class SparseArray {

    static ArrayList<db_input> overflowing_bucket = new ArrayList<>();

    static ArrayList<db_input> dense_array = new ArrayList<>();
    public static ArrayList<db_input> sparse_array = new ArrayList<>();

    static int amount_of_records = 100;

    public SparseArray(ArrayList<db_input> dense_array, ArrayList<db_input> sparse_array)
    {
        SparseArray.dense_array = dense_array;
        SparseArray.sparse_array = sparse_array;
    }

    public SparseArray(){ }

    public static void setOverflowing_bucket(ArrayList<db_input>arr)
    {
        overflowing_bucket = new ArrayList<>();
        overflowing_bucket.addAll(arr);
    }

    public static ArrayList<db_input> getSparseArray()
    {
        return sparse_array;
    }

    public static ArrayList<db_input> getOverflowBucket()
    {
        return overflowing_bucket;
    }

    public static void make_dense_sparse()
    {
        ArrayList<Integer> indexes_dense = get_all_indexes(dense_array);
        int maximum = arr_work.find_max_arr_list(indexes_dense);
        for (int i =0; i<=maximum;i++) {
            if(indexes_dense.contains(i)) {
                if (sparse_array.size() >= amount_of_records) {
                    overflowing_bucket.add(dense_array.get(indexes_dense.indexOf(i)));
                } else sparse_array.add(dense_array.get(indexes_dense.indexOf(i)));
            }
        }


    }

    public static ArrayList<db_input> getOverflowing_bucket()
    {
        return overflowing_bucket;
    }

    public static ArrayList<Integer> get_all_indexes(ArrayList<db_input> dense_array)
    {
        ArrayList<Integer>answer = new ArrayList<>();
        for (db.db_input db_input : dense_array) {
            answer.add(db_input.index);
        }

        return answer;

    }

    public static ArrayList<db_input> make_sparse_dense(ArrayList<db_input>sparse)
    {
        ArrayList<db_input> dense = new ArrayList<>();
        for(db_input i : sparse)
            if(i != null)
                dense.add(i);
        return dense;
    }
}
