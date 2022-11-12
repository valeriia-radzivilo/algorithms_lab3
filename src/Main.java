import db.*;
import interface_for_db.*;

import javax.swing.*;
import java.io.IOException;

import static interface_for_db.db_interface.create_frame;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JFrame frame= new JFrame("DB");

        String pathname = "lab3_db.txt";
        int amount_of_records = 5;
        WriterReader.main(amount_of_records,pathname);
        db_input[] get_from_db = WriterReader.read_file(pathname,amount_of_records);
        System.out.println("DB:");
        arr_work.print_arr(get_from_db);
        int[] indexes = arr_work.get_indexes(get_from_db,amount_of_records);
        int[] values = arr_work.get_values(get_from_db,amount_of_records);
        create_frame(frame,indexes,values);





//        db_interface.create_frame(frame);
    }
}