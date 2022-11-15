package db;

import java.util.ArrayList;

public class arr_work {

    public static String make_text_from_matrix(String[][] matrix)
    {
        String answer = "";
        for(int i=0; i < matrix.length;i++)
        {
            for(int j=0; j<matrix.length;j++)
            {
                answer+=matrix[i][j];
                answer+=" ";
            }
            answer+="\n";

        }
        return  answer;
    }

    public static void print_arr_list(ArrayList<db_input> arr)
    {
        for (db.db_input db_input : arr)
        {
            if(db_input!=null) System.out.println(db_input.toString());
        }
    }

    public static ArrayList<Integer> get_indexes(ArrayList<db_input>arr)
    {
        ArrayList<Integer>indexes = new ArrayList<>();
        for (db.db_input db_input : arr) if (db_input != null) indexes.add(db_input.getIndex());
        return indexes;
    }

    public static ArrayList<Integer> get_values(ArrayList<db_input>arr)
    {
        ArrayList<Integer> indexes = new ArrayList<>();
        for (db.db_input db_input : arr) if (db_input != null) indexes.add(db_input.getValue());
        return indexes;
    }

    public static int find_max_arr_list(ArrayList<Integer> arr)
    {
        int maximum = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (maximum < arr.get(i))
                maximum = arr.get(i);
        }
        return maximum;
    }


}
