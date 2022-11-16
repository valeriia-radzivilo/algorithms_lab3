package db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SparseArray {
    static ArrayList<db_input> dense_array = new ArrayList<>(1000);
    static ArrayList<db_input> sparse_array = new ArrayList<>(1000);


    public SparseArray(ArrayList<db_input> dense_array, ArrayList<db_input> sparse_array)
    {
        SparseArray.dense_array = dense_array;
        SparseArray.sparse_array = sparse_array;
    }

    public SparseArray(){ }

    public static void make_dense_sparse(ArrayList<db_input> dense_array, ArrayList<db_input> sparse_array)
    {
        ArrayList<Integer> indexes_dense = get_all_indexes(dense_array);
        int maximum = arr_work.find_max_arr_list(indexes_dense);
        for (int i =0; i<=maximum;i++) {
            if(indexes_dense.contains(i)) {
                int amount_of_i =arr_work.find_amount_of_value(indexes_dense,i);
                if(amount_of_i>1)
                {
                    for(int j =0; j<amount_of_i;j++) {
                        sparse_array.add(dense_array.get(indexes_dense.indexOf(i)));
                        dense_array.set(indexes_dense.indexOf(i),new db_input(maximum+1,maximum+1));
                        indexes_dense = get_all_indexes(dense_array);

                    }
                }
                    else
                        sparse_array.add(dense_array.get(indexes_dense.indexOf(i)));
            }
            else
                sparse_array.add(null);

        }
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
