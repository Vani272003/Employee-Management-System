package com.javaproject.empms;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeImplement implements EmployeeInter
{
     Connection con;
    @Override
    public void createEmployee(Employee emp)
    {
        con= DBConnection.createDBConnection();
        String query="insert into employee(id,name,salary,age) values(?,?,?,?)";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            int count=pstm.executeUpdate();
            if(count!=0)
            {
                System.out.println("Employee Inserted Successfully !");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployee() {
        con=DBConnection.createDBConnection();
        String query="select * from employee";
        try
        {
            Statement stat=con.createStatement();
            ResultSet result=stat.executeQuery(query);
            System.out.println("----------------------------------");
            while(result.next())
            {
                System.out.format("%d\t%s\t%f\t%d\n",result.getInt("id"),result.getString("name")
                        ,result.getDouble("salary"),result.getInt("age"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedonId(int id) {
        con=DBConnection.createDBConnection();
        String query="select * from employee where id="+id;
        try
        {
            Statement stat=con.createStatement();
            ResultSet result=stat.executeQuery(query);
            System.out.println("-----------------------------------------------");
            while(result.next())
            {
                System.out.format("%d\t%s\t%f\t%d\n",result.getInt("id"),result.getString("name")
                        ,result.getDouble("salary"),result.getInt("age"));
            }
            System.out.println("-------------------------------------------------");
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name)
    {
        con=DBConnection.createDBConnection();
        String query="update employee set name=?where id=?";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
            {
                System.out.println("Employee Details Updated Successfully !");
            }
        }
        catch (Exception ex)
        {

        }

    }

    @Override
    public void deleteEmployee(int id)
    {
        con=DBConnection.createDBConnection();
        String query="delete from employee where id=?";
        try
        {
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
            {
                System.out.println("Employee Deleted Successfully!"+id);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();;
        }


    }
}
