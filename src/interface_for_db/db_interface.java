package interface_for_db;
import com.sun.tools.javac.Main;
import db.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class db_interface {

    public static void create_frame(JFrame frame, ArrayList<Integer>indexes, ArrayList<Integer>values)
    {
        JPanel panel = new JPanel();
        panel.setAutoscrolls(true);
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 2;
        c.gridy = 0;
        // create a label to display text
        JLabel l = new JLabel();

        // add text to label
        l.setText("Database:");

        panel.add(l,c);

        show_db(panel,c, indexes,values);






        c.gridx = 2;
        c.gridy = values.size()+1;
        JLabel text_change = new JLabel("CHANGE DATABASE: ");
        panel.add(text_change,c);


        c.gridx = 1;
        c.gridy = values.size()+3;
        JTextField input_index = new JTextField("index");
        panel.add(input_index,c);
        c.gridx = 3;
        c.gridy = values.size()+3;
        JTextField input_value = new JTextField("value");
        panel.add(input_value,c);

        buttons_add_del(frame, c,indexes,values,panel,input_index,input_value);













        frame.add(panel);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
        frame.setSize(600, 600);

    }

    static void show_db(JPanel panel, GridBagConstraints c, ArrayList<Integer> indexes , ArrayList<Integer> values)
    {

            for(int j =0; j<indexes.size();j++) {
                c.gridx = 1;
                c.gridy = j+1;
                panel.add(new JLabel(Integer.toString(indexes.get(j))+"     "),c);
            }

        for(int j =0; j<values.size();j++) {
            c.gridx = 3;
            c.gridy = j+1;
            panel.add(new JLabel(Integer.toString(values.get(j))),c);
        }

    }

    public static void buttons_add_del(JFrame frame, GridBagConstraints c, ArrayList<Integer>indexes, ArrayList<Integer>values,JPanel panel,JTextField input_index,JTextField input_value)   {
        c.gridx = 1;
        c.gridy = values.size()+4;
        JButton b_add=new JButton("Add");
        b_add.setBounds(50,100,95,30);
        b_add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.updateComponentTreeUI(panel);
                String str_us_index = input_index.getText();
                String str_us_value = input_value.getText();
                if (!str_us_value.equals("value") && !str_us_index.equals("index")) {

                    int user_index = Integer.parseInt(str_us_index);
                    int user_value = Integer.parseInt(str_us_value);
                    db_input user_input = new db_input(user_index, user_value);
                    ArrayList<db_input>new_db =new ArrayList<>();
                    for(int i =0; i<indexes.size();i++)
                    {
                        db_input input = new db_input(indexes.get(i),values.get(i));
                        new_db.add(input);
                    }
                    new_db.add(user_input);
                    try {
                        frame.setVisible(false);
                        frame.dispose();

                        WriterReader.write_to_db(new_db);
                        with_changes.add_changes(new_db);
                    } catch (IOException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }


                }
            }

        });
        panel.add(b_add,c);



        c.gridx = 3;
        c.gridy = values.size()+4;
        JButton b_del=new JButton("Delete");
        b_del.setBounds(50,100,95,30);
        panel.add(b_del,c);
        b_del.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.updateComponentTreeUI(panel);
                String str_us_index = input_index.getText();
                String str_us_value = input_value.getText();
                if (!str_us_value.equals("value") && !str_us_index.equals("index")) {

                    int user_index = Integer.parseInt(str_us_index);
                    int user_value = Integer.parseInt(str_us_value);
                    if (values.contains(user_value) && indexes.contains(user_index)) {
                        int del_index = values.indexOf(user_value);
                        db_input user_input = new db_input(user_index, user_value);
                        ArrayList<db_input> new_db = new ArrayList<>();
                        for (int i = 0; i < indexes.size(); i++) {
                            db_input input = new db_input(indexes.get(i), values.get(i));
                            if(i!=del_index)
                                new_db.add(input);
                        }
                        try {
                            frame.setVisible(false);
                            frame.dispose();

                            WriterReader.write_to_db(new_db);
                            with_changes.add_changes(new_db);
                        } catch (IOException | ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }


                    }
                }
            }

        });



        c.gridx = 2;
        c.gridy = values.size()+4;
        JButton b_ref=new JButton("Refresh");
        b_ref.setBounds(50,100,95,30);
        panel.add(b_ref,c);
        b_ref.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.updateComponentTreeUI(panel);


            }});
    }













}
