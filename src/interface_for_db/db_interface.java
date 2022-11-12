package interface_for_db;
import db.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class db_interface {

    public static void create_frame(JFrame frame, int[]indexes, int[]values)
    {
        // create a label to display text
        JLabel l = new JLabel();

        // add text to label
        l.setText("DB:");
        // create a panel
        JPanel p = new JPanel();

        // add label to panel
        p.add(l);
        frame.add(p);
        show_db(frame,indexes,values);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);

    }

    static void show_db(JFrame frame, int[] indexes , int[] values)
    {


        JPanel panel_db = new JPanel();
        for(int i =0;i<indexes.length; i++)
        {

            JTextArea index = new JTextArea(values.length,2);
            index.add(Integer.toString(indexes[i])+"  "+Integer.toString(values[i]),);
            panel_db.add(index);
            index.setEditable(false);
        }


        // add panel to frame

        frame.add(panel_db);



    }

}
