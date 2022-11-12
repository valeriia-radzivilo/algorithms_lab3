package db;

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

    public static void print_arr(db_input[]arr)
    {
        for (db.db_input db_input : arr) System.out.println(db_input.toString());
    }

    public static int[] get_indexes(db_input[]arr, int amount)
    {
        int []indexes = new int[amount];
        for (int i =0; i<amount;i++)
            indexes[i] = arr[i].getIndex();
        return indexes;
    }

    public static int[] get_values(db_input[]arr, int amount)
    {
        int []indexes = new int[amount];
        for (int i =0; i<amount;i++)
            indexes[i] = arr[i].getValue();
        return indexes;
    }


}
