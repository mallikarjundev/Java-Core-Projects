package org.example;

import java.util.ArrayList;
import java.util.List;

abstract class Employee {

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculatedSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculatedSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {

        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatedSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {

    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatedSalary() {
        return hourlyRate*hoursWorked;
    }
}

class PayRollSystem{
    private List<Employee> employeeList;

    public PayRollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){

        Employee employeeToRemove = null;
        for (Employee employee: employeeList){
            if (employee.getId()==id){
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees(){
        for (Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayRollSystem payRollSystem = new PayRollSystem();

        FullTimeEmployee emp1 = new FullTimeEmployee("John Doe", 101, 5000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Jane Smith", 102, 30, 15.0);

        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);
        System.out.println("Initial Employee Details:");
        payRollSystem.displayEmployees();

        System.out.println("\n Removing Employee....");
        payRollSystem.removeEmployee(101);

        System.out.println("\nRemaining Employee Details:");
        payRollSystem.displayEmployees();
    }
}