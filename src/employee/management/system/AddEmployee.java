package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame implements ActionListener{
      JTextField tname, tfname,tsalary, taddress,tphone,temail,taadhar,tdesignation;
      JDateChooser tdob;
      JComboBox Boxeducation;

      Random ran=new Random();
      int number=ran.nextInt(999999);

      JLabel tempid;
      JButton add, back;



      AddEmployee() {



          JLabel heading=new JLabel("Add Employee Detail");
          heading.setBounds(300,30,300,30);
          heading.setFont(new Font("serif",Font.BOLD,25));
          add(heading);


            //NAME
          JLabel name =new JLabel("Name :");
          name.setBounds(50,100,100,20);
          add(name);

          tname=new JTextField();
          this.tname.setBounds(200,100,200,20);
          add(this.tname);

          //fathername,
          JLabel fname=new JLabel("Father's Name :");
          fname.setBounds(500,100,100,20);
          add(fname);

          tfname=new JTextField();
          tfname.setBounds(650,100,200,20);
          add(tfname);


          //DOB
          JLabel dob=new JLabel("Date Of Birth :");
          dob.setBounds(50,150,100,20);
          add(dob);

          tdob=new JDateChooser();
          tdob.setBounds(200,150,200,20);
          tdob.setBackground(new Color(177,252,197));
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
          Boxeducation=new JComboBox(items);
          Boxeducation.setBounds(650,250,200,20);
          add(Boxeducation);



          //adhaarnumber;
          JLabel aadhar=new JLabel("Aadhar Number :");
          aadhar.setBounds(500,300,100,20);
          add( aadhar);

          taadhar=new JTextField();
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

          tempid =new JLabel(""+number);
          tempid.setBounds(200,350,200,20);
          tempid.setFont(new Font("Raleway",Font.BOLD,15));
          tempid.setForeground(Color.red);
          add(tempid);







          add=new JButton("ADD");
          add.setBounds(270,450,150,30);
          add.setForeground(Color.WHITE);
          add.setBackground(Color.BLACK);
          add.addActionListener(this);
          add(add);

          back=new JButton("BACK");
          back.setBounds(470,450,150,30);
          back.setForeground(Color.WHITE);
          back.setBackground(Color.BLACK);
          back.addActionListener(this);
          add(back);









          getContentPane().setBackground(new Color(160, 255, 192));




          setSize(900,550);
          setLayout(null);
          setLocation(160,60);
          setVisible(true);
      }

      @Override
      public void actionPerformed(ActionEvent e){
          if(e.getSource()==add){
              String name=tname.getText();
              String fname=tfname.getText();
              String dob=((JTextField) tdob.getDateEditor().getUiComponent()).getText();
              String salary=tsalary.getText();
              String address=taddress.getText();
              String phone=tphone.getText();
              String email=temail.getText();
              String education=(String) Boxeducation.getSelectedItem();
              String designation=tdesignation.getText();
              String empID=tempid.getText();
              String aadhar=taadhar.getText();



              try{
                  Conn c=new Conn();//employee(name varchar(40),fname varchar(40),dob varchar(40),salary varchar(40),address varchar(40),phone varchar(40),email varchar(40),education varchar(40),designation varchar(40),aadhar  varchar(40),empID varchar(40));
                  String query="insert into employee  values ('" + name + "','" + fname + "','" + dob + "','" + salary + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + designation + "','" + aadhar + "','" + empID+ "')";

                  c.statement.executeUpdate(query);
                  JOptionPane.showMessageDialog(null,"Details Added Successfully!");
                  setVisible(false);
                  new Main_class();
              }
              catch(Exception ex){
                  JOptionPane.showMessageDialog(null,"Database Error: " + ex.getMessage());
                  ex.printStackTrace();

              }



          }

          else if (e.getSource() == back) {

              setVisible(false);
              new Main_class();
          }









      }



      public static void main(String[] args){
          new AddEmployee();
      }
}






//String query="insert into employee ('"+Name_+"', '"+DOB_+"','"+Address_+"','"+Email_+"','"+Designation_+"','"+fathername_+"','"+Salary_+"','"+Phone_+"','"+HighestEdu_+"','"+AadharNumber_+"','"+EmployeeID_+"')";