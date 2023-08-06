package com.javaproject.empms;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection
{
    static Connection con;
    public static  Connection createDBConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/employeedb?allowPublicKeyRetrieval=true&useSSL=false";

            String username="root";
            String password="8870";
           con= DriverManager.getConnection(url,username,password);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return con;
    }
}
