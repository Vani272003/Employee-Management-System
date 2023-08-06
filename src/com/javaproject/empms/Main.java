

package com.javaproject.empms;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeInter  data=new EmployeeImplement();
        System.out.println("Welcome to Employee Management application");


        Scanner sc=new Scanner(System.in);
        System.out.println("--------------------------------------------");

        do{
            System.out.println("--------------------------------------------");
            System.out.println("1.Add Employee\n"+
                    "2.Show All Employee \n" +
                    "3.Show Employee based on id\n"+
                    "4.Update the employee\n" +
                    "5.Delete the employee\n"+"6.exit\n");
            System.out.println("-----------------------------------------");
            System.out.println("Enter Choice : ");
            int choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    Employee emp=new Employee();
                    System.out.println("Enter ID: ");
                    int id=sc.nextInt();
                    System.out.println("Enter name ");
                    String name=sc.next();
                    System.out.println("Enter Salary: ");
                    sc.nextLine();
                    double salary=sc.nextDouble();
                    System.out.println("Enter age");
                    System.out.println("-------------------------------------");
                    int age=sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    data.createEmployee(emp);
                    emp.setSalary(salary);
                    break;
                case 2:
                    data.showEmployee();
                    break;
                case 3:
                    System.out.println("Enter id to show the details ");;
                     id=sc.nextInt();
                    data.showEmployeeBasedonId(id);
                case 4:
                    System.out.println("Enter id to update the details");
                    id=sc.nextInt();
                    System.out.println("Enter the name");
                    name=sc.next();
                    data.updateEmployee(id,name);
                case 5:
                    System.out.println("Enter the id to delete");
                    id=sc.nextInt();
                    data.deleteEmployee(id);
                    break;

                case 6:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid choice!");
                    break;

            }
        }
        while(true);

    }
}
