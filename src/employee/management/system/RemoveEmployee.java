package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener{

    Choice choiceEMPID;
    JButton delete, back;
    RemoveEmployee(){



        JLabel label=new JLabel("Employee ID:");
        label.setBounds(50,50,120,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        add(choiceEMPID);

        try{
            Conn c =new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEMPID.add(resultSet.getString("empID"));

            }
        }catch(Exception E){
            E.printStackTrace();

        }

//NAME
        JLabel labelName=new JLabel("Name :");
        labelName.setBounds(50,100,300,30);
        labelName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelName);

        JLabel textName=new JLabel();
        textName.setBounds(200,100,300,30);
        textName.setFont(new Font("Tahoma",Font.BOLD,15));
        add(textName);

//phone

        JLabel labelPhone=new JLabel("Phone :");
        labelPhone.setBounds(50,150,300,30);
        labelPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelPhone);

        JLabel textPhone=new JLabel();
        textPhone.setBounds(200,150,300,30);
        textPhone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(textPhone);


//Email
        JLabel labelEmail=new JLabel("Email :");
        labelEmail.setBounds(50,200,300,30);
        labelEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelEmail);

        JLabel textEmail=new JLabel();
        textEmail.setBounds(200,200,300,30);
        textEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(textEmail);


        try{
            Conn c =new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from employee where empID='"+choiceEMPID.getSelectedItem()+"'");
            while(resultSet.next()){
                textName.setText(resultSet.getString("name"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));

            }
        }catch(Exception E){
            E.printStackTrace();

        }

        choiceEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try{
                    Conn c =new Conn();
                    ResultSet resultSet=c.statement.executeQuery("select * from employee where empID='"+choiceEMPID.getSelectedItem()+"'");
                    while(resultSet.next()){
                        textName.setText(resultSet.getString("name"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));

                    }

                }catch(Exception E){
                    E.printStackTrace();

                }

            }
        });


        delete=new JButton("DELETE");
        delete.setBounds(240,300,150,30);
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.BLACK);
        delete.addActionListener(this);
        add(delete);

        back=new JButton("BACK");
        back.setBounds(470,300,150,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Images/delete.png"));
        Image i22 = i11.getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image22 = new JLabel(i33);
        image22.setBounds(650, 30, 150, 200);
        add(image22);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/rback.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image2 = new JLabel(i3);
        image2.setBounds(0, 0, 900, 400);
        add(image2);

        setSize(900,400);
        setLayout(null);
        setLocation(200,100);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==delete){
        try{
                Conn c=new Conn();
                String query="delete from employee where empID='"+choiceEMPID.getSelectedItem()+ "'";
                c.statement.executeUpdate(query);
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
                setVisible(false);
                new Main_class();
            }catch(Exception E){
                E.printStackTrace();
            }


        } else{
            setVisible(false);
            new ViewEmployee();
        }


    }

    public static void main(String [] args){
          new RemoveEmployee();
    }
}
