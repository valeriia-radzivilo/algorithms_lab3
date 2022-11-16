package interface_for_db;

import db.SparseArray;
import db.WriterReader;
import db.arr_work;
import db.db_input;

import javax.swing.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static interface_for_db.db_interface.create_frame;

public class with_changes {

    public static void add_changes(ArrayList<db_input> new_db) throws IOException, ClassNotFoundException {
        JFrame frame= new JFrame("DB");
        ArrayList<db_input> from_file = WriterReader.read_file(new_db.size());
        System.out.println("DB AFTER CHANGES");
        System.out.println("---------");
        arr_work.print_arr_list(from_file);
        System.out.println("---------");

        ArrayList<db_input>get_from_db = new ArrayList<>();
        SparseArray sparseArray = new SparseArray(from_file,get_from_db);
        SparseArray.make_dense_sparse();

        System.out.println("Overflow:");
        arr_work.print_arr_list(sparseArray.getOverflowing_bucket());

        ArrayList<Integer> indexes = arr_work.get_indexes(get_from_db);
        ArrayList<Integer> values = arr_work.get_values(get_from_db);
        create_frame(frame,indexes,values,sparseArray);
    }
}
