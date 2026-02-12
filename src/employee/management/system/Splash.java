package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame {

    Splash(){ //constructor
        //all the elements or items you want to show on frame always keep them on front
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Images/front.gif")); //storing image in i1(imageicon object) , jlabel displays image using ImageIcon ,not raw Image
        Image i2 = i1.getImage().getScaledInstance(970, 550, Image.SCALE_DEFAULT ); //getimage fetch image ,getscaled scaled image(resize) again
        ImageIcon i3=new ImageIcon(i2); //convert the scaled image back into image icon
        JLabel image=new JLabel(i3); //create a jlabel and place image inside it
        image.setBounds(0,0,970,550);
        add(image);

        setSize(970, 550);      //fixing size and width of the window
        setLayout(null);                        //default layout=null cause we have to set our own layout
        setVisible(true);                       //cause the default visibility is false
        setLocation(150,80);                //location of frame on our window , Bydefault it appers on the left most corner



        try{
             Thread.sleep(5000);  //this is beacuse after 5 seconds the image get blocked and login page will  appear
             setVisible(false);
             new Login();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        new Splash(); //constructor object

    }
}
