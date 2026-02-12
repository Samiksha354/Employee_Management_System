package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





public class Login extends JFrame implements ActionListener{

    JTextField usernametext, passwordtext;
    JButton login, back;

    Login() {


        JLabel username = new JLabel("Username :"); //to create text on the frame
        username.setBounds(40, 15, 100, 30); //textfield
        add(username);

        usernametext = new JTextField("");
        usernametext.setBounds(140, 15, 150, 25); //textfield
        add(usernametext);

        JLabel password = new JLabel("Password :"); //to create password
        password.setBounds(40, 65, 100, 30);
        add(password);

        passwordtext = new JTextField("");
        passwordtext.setBounds(140, 65, 150, 25); //textfield
        add(passwordtext);

        login = new JButton("LOGIN");
        login.setBounds(140, 155, 150, 25);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(140, 190, 150, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        //background ke upper wala icon
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Images/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel image22 = new JLabel(i33);
        image22.setBounds(350, 40, 600, 300);
        add(image22);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image2 = new JLabel(i3);
        image2.setBounds(0, 0, 600, 300);
        add(image2);


        setSize(600, 300);
        setLocation(350, 250);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == login){
            try{
                String username=usernametext.getText();
                String password=passwordtext.getText();

                Conn Conn=new Conn();

                String query="select* from login where username ='"+ username +"' and password ='"+password+"'";
                ResultSet resultSet=Conn.statement.executeQuery(query);

                if(resultSet.next()){
                    setVisible(false);
                    new Main_class();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                 }


            }catch(Exception E){
                 E.printStackTrace();
            }

        }
        else if ( e.getSource() == back){
            System.exit(90); //exit code ,any value
            //Process finished with exit code 90 (this will shown in the output field)

        }
    }



    public static void main(String[] args){
        new Login();
    }
}
