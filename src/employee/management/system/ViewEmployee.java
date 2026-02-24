package employee.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee  extends JFrame implements ActionListener{
    JTable table;
    Choice choiceEMP;
    JButton search,print,update,back;

       ViewEmployee(){




           getContentPane().setBackground(new Color(255,131,122));

           JLabel searchheading=new JLabel("Search by employee id");
           searchheading.setBounds(20,20,150,20);
           add(searchheading);


           choiceEMP=new Choice();
           choiceEMP.setBounds(190,20,150,20);
           add(choiceEMP);
           try{
               Conn c=new Conn();
               ResultSet resultSet =c.statement.executeQuery("select * from employee");
               while(resultSet.next()){
                   choiceEMP.add(resultSet.getString("empId"));
               }


           }catch(Exception e){
                e.printStackTrace();
           }


           table=new JTable();
           try{
               Conn c=new Conn();
               ResultSet resultSet=c.statement.executeQuery("Select * from employee");
               table.setModel(DbUtils.resultSetToTableModel(resultSet));

           }catch(Exception e){
               e.printStackTrace();
           }

           JScrollPane jp=new JScrollPane(table);
           jp.setBounds(0,110,990,600);
           add(jp);




           search=new JButton("Search");
           search.setBounds(20 ,70,100,20);
           search.addActionListener(this);
           add(search);

           print=new JButton("Print");
           print.setBounds(140 ,70,100,20);
           print.addActionListener(this);
           add(print);

           update=new JButton("Update");
           update.setBounds(260 ,70,100,20);
           update.addActionListener(this);
           add(update);

           back=new JButton("Back");
           back.setBounds(380 ,70,100,20);
           back.addActionListener(this);
           add(back);







           setSize(1000, 550);
           setLocation(150,80);
           setLayout(null);
           setVisible(true);

       }



       @Override
       public void actionPerformed(ActionEvent e){
           if(e.getSource() == search){
               String query="select * from employee where empId = '"+ choiceEMP.getSelectedItem() + "' ";
               try{
                   Conn c=new Conn();
                   ResultSet resultSet= c.statement.executeQuery(query);
                   table.setModel(DbUtils.resultSetToTableModel(resultSet));

               }catch(Exception E){
                   E.printStackTrace();

               }
           }

           else if(e.getSource()==print){
               try{
                   table.print();
               }catch(Exception EE){
                   EE.printStackTrace();

               }

           }

           else if(e.getSource()==update){
               try{
                   setVisible(false);
                   new UpdateEmployee(choiceEMP.getSelectedItem());

               }catch(Exception EEE){
                   EEE.printStackTrace();

               }

           }

           else {
               setVisible(false);
               new Main_class();
           }

    }
       public static void main(String[] args){
           new ViewEmployee();
       }
}
