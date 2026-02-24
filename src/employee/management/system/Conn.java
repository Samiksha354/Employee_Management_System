package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {



    Connection connection;
    Statement statement;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","Asthetic@123");
            statement=connection.createStatement();
            System.out.println("Database Connected Successfully");
            System.out.println("connection = " + connection);
            System.out.println("statement = " + statement);
        }catch(Exception e){
            System.out.println("Database Connection Failed");
            e.printStackTrace();

        }
    }
}
