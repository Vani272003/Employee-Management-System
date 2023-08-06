package com.javaproject.empms;

public interface EmployeeInter
{
    public void createEmployee(Employee emp);
    public void showEmployee();
    public void showEmployeeBasedonId(int id);
    public void updateEmployee(int id,String name);
    public void deleteEmployee(int id);
}
