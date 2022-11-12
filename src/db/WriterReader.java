package db;

import java.io.*;
import java.util.Random;

public class WriterReader {

    public static void main(int amount_input, String pathname) {


        try {
            FileOutputStream f = new FileOutputStream(new File(pathname));
            ObjectOutputStream o = new ObjectOutputStream(f);


            for(int i =0; i<amount_input;i++)
            {
                Random value = new Random();
                    db_input input = new db_input(i, value.nextInt(1000));
                // Write objects to file
                o.writeObject(input);
            }




            o.close();
            f.close();



        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }

    }

    public static db_input[] read_file(String pathname, int amount) throws IOException, ClassNotFoundException {
        FileInputStream fi = new FileInputStream(new File(pathname));
        ObjectInputStream oi = new ObjectInputStream(fi);

        // Read objects
       db_input[] get_input = new db_input[amount];


        for(int i =0; i< amount;i++)
        {
           get_input[i] = (db_input) oi.readObject();

        }

        oi.close();
        fi.close();
        return get_input;
    }

}