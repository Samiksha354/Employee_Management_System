package employee.management.system;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

public class UpdateEmployee extends JFrame implements ActionListener{
    JTextField  tsalary, taddress,tphone,temail,tdesignation;
    JComboBox teducation;

    JButton update, back;
    JLabel tempid;
    String number;


    UpdateEmployee(String number){
        this.number=number;
        getContentPane().setBackground(new Color(160, 255, 192));

        JLabel heading=new JLabel("Update Employee Detail");
        heading.setBounds(300,30,300,30);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);


        //NAME
        JLabel name =new JLabel("Name :");
        name.setBounds(50,100,100,20);
        add(name);

        JLabel tname=new JLabel();
        tname.setBounds(200,100,200,20);
        add(tname);

        //fathername,
        JLabel fname=new JLabel("Father's Name :");
        fname.setBounds(500,100,100,20);
        add(fname);

        JLabel  tfname=new JLabel ();
        tfname.setBounds(650,100,200,20);
        add(tfname);


        //DOB
        JLabel dob=new JLabel("Date Of Birth :");
        dob.setBounds(50,150,100,20);
        add(dob);

        JLabel tdob=new JLabel();
        tdob.setBounds(200,150,100,20);
        add(tdob);




        //salary,
        JLabel salary=new JLabel("Salary :");
        salary.setBounds(500,150,100,20);
        add(salary);

        tsalary=new JTextField();
        tsalary.setBounds(650,150,200,20);
        add(tsalary);



        // address
        JLabel address=new JLabel("Address :");
        address.setBounds(50,200,100,20);
        add(address);

        taddress=new JTextField();
        taddress.setBounds(200,200,200,20);
        add(taddress);


        //phone,
        JLabel phone=new JLabel("Phone :");
        phone.setBounds(500,200,100,20);
        add(phone);

        tphone=new JTextField();
        tphone.setBounds(650,200,200,20);
        add(tphone);


        // email
        JLabel email=new JLabel("Email :");
        email.setBounds(50,250,100,20);
        add(email);

        temail=new JTextField();
        temail.setBounds(200,250,200,20);
        add(temail);


        //highestedu
        JLabel education=new JLabel("Highest Edu. :");
        education.setBounds(500,250,100,20);
        add(education);

        String items[]={"BBA","B.SC","MSC","B.COM","B.E","M.E","B.Tech","M.Tech","MBA","MCA","PHD"};
        teducation=new JComboBox(items);
        teducation.setBounds(650,250,200,20);
        add(teducation);

        //adhaarnumber;
        JLabel aadhar=new JLabel("Aadhar Number :");
        aadhar.setBounds(500,300,100,20);
        add( aadhar);

        JLabel taadhar=new JLabel();
        taadhar.setBounds(650,300,200,20);
        add(taadhar);


        //designation,
        JLabel designation=new JLabel("Designation :");
        designation.setBounds(50,300,100,20);
        add(designation);

        tdesignation=new JTextField();
        tdesignation.setBounds(200,300,200,20);
        add(tdesignation);


        //employeeID

        JLabel empid=new JLabel("Employee ID :");
        empid.setBounds(50,350,100,20);
        add(empid);

        tempid =new JLabel();
        tempid.setBounds(200,350,200,20);
        tempid.setFont(new Font("Raleway",Font.BOLD,15));
        tempid.setForeground(Color.red);
        add(tempid);





        try{
          Conn c=new Conn();
          String query="select * from employee where empID='"+number+"'";
          ResultSet resultSet=c.statement.executeQuery(query);
          while(resultSet.next()){
              tname.setText(resultSet.getString("name"));
              tfname.setText(resultSet.getString("fname"));
              tdob.setText(resultSet.getString("dob"));
              taddress.setText(resultSet.getString("address"));
              tsalary.setText(resultSet.getString("salary"));
              tphone.setText(resultSet.getString("phone"));
              temail.setText(resultSet.getString("email"));
              teducation.setSelectedItem(resultSet.getString("education"));
              taadhar.setText(resultSet.getString("aadhar"));
              tempid.setText(resultSet.getString("empID"));
              tdesignation.setText(resultSet.getString("designation"));
          }
        }catch(Exception e){
            e.printStackTrace();
        }









        update=new JButton("UPDATE");
        update.setBounds(270,450,150,30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(this);
        add(update);

        back=new JButton("BACK");
        back.setBounds(470,450,150,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);

        setSize(900,550);
        setLayout(null);
        setLocation(160,60);
        setVisible(true);


    }


    @Override
        public void actionPerformed(ActionEvent e){
        if(e.getSource() == update){

            String salary=tsalary.getText();
            String address=taddress.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education=(String) teducation.getSelectedItem();
            String designation=tdesignation.getText();

            try{
                Conn c=new Conn();
                String query="update employee set  salary='"+salary+"', address='"+address+"', phone='"+phone+"', email='"+email+"',education='"+education+"',designation='"+designation+"'  where empID ='"+number+"' ";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
            }catch(Exception E){
                E.printStackTrace();
            }


        }
        else{
            setVisible(false);
            new ViewEmployee();
        }


    }
    public static void main(String [] args){
    new UpdateEmployee("");
    }
}
