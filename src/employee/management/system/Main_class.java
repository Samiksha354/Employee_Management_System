package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Main_class extends JFrame  {
    JButton addemployee, viewemployee, removeemployee;



     Main_class(){

         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/home.jpg"));
         Image i2= i1.getImage().getScaledInstance(1000,550,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image4 = new JLabel(i3);
         image4.setBounds(0, 0, 1000, 550);
         add(image4);



         JLabel heading=new JLabel("Employee Management System");
         heading.setBounds(290 ,150, 500,30);
         heading.setFont(new Font("Raleway",Font.BOLD,25));
         image4.add(heading);




         addemployee=new JButton("ADD EMPLOYEE");
//         addemployee.setLocation(20 , 50);
         addemployee.setBounds(280, 230, 170, 30);
         addemployee.setForeground(Color.white);
         addemployee.setBackground(Color.black);
         addemployee.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                new AddEmployee();
                setVisible(false);
             }
         });
         image4.add(addemployee);




         viewemployee=new JButton("VIEW EMPLOYEE");
//         viewemployee.setLocation(100,50);
         viewemployee.setBounds(490, 230, 170, 30);
         viewemployee.setForeground(Color.white);
         viewemployee.setBackground(Color.black);
         viewemployee.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new ViewEmployee();
                 setVisible(false);

             }
         });
         image4.add(viewemployee);




         removeemployee=new JButton("REMOVE EMPLOYEE");
//         removeemployee.setLocation(60,150);
         removeemployee.setBounds(380, 310, 170, 30);
         removeemployee.setForeground(Color.white);
         removeemployee.setBackground(Color.black);
         removeemployee.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new RemoveEmployee();
                 setVisible(false);

             }
         });
         image4.add(removeemployee);






         setSize(1000, 550);
         setLocation(150,80);
         setLayout(null);
         setVisible(true);



     }
    public static void main(String[] arsg){
        new Main_class();
    }
}
