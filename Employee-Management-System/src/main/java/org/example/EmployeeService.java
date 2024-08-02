package org.example;

import java.util.HashSet;
import java.util.Scanner;

public class EmployeeService {
    HashSet<Employee> empset = new HashSet<>();

    Employee emp1 = new Employee(1, "Malli", 24, "IT", "Developer", 25000);
    Employee emp2 = new Employee(2, "karthik", 29, "Engineering Service", "Tester", 80000);
    Employee emp3 = new Employee(3, "Kiran", 26, "Admin", "DevOps Eng", 52000);
    Employee emp4 = new Employee(4, "Sheela", 24, "IT", "System Eng", 26000);

    Scanner sc = new Scanner(System.in);

    int id, age;
    String name, department, designation;
    double sal;
    boolean found = false;

    public EmployeeService() {
        empset.add(emp1);
        empset.add(emp2);
        empset.add(emp3);
        empset.add(emp4);
    }

    public void addEmp() {
        System.out.println("Please enter empid");
        id = sc.nextInt();
        for (Employee employee : empset) {
            if (employee.getId() == id) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Employee with id already exists");
        } else {

            System.out.println("Please enter name");
            name = sc.next();
            System.out.println("Please enter age");
            age = sc.nextInt();
            System.out.println("Please enter department");
            department = sc.next();
            System.out.println("Please enter designation");
            designation = sc.next();
            System.out.println("Please enter salary");
            sal = sc.nextDouble();

            empset.add(new Employee(id, name, age, department, designation, sal));
            System.out.println("Added successfully");
        }

    }

    public void getEmpById() {
        System.out.println("Please enter empid");
        id = sc.nextInt();
        for (Employee employee : empset) {
            if (employee.getId() == id) {
                System.out.println(employee);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee not found");
        }
    }

    public void updateEmployee() {
        System.out.println("enter empid to update");
        id = sc.nextInt();

        for (Employee employee : empset) {
            if (employee.getId() == id) {
                System.out.println(employee);
                System.out.println("enter name");
                name = sc.next();
                System.out.println("enter salary");
                sal = sc.nextDouble();

                employee.setName(name);
                employee.setSalary(sal);

                System.out.println("\n updated details\n" + employee);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Employee not found");
        }
    }

    public void deleteEmployee() {
        System.out.println("enter empid to delete");
        id = sc.nextInt();
        Employee deleteEmp = null;
        for (Employee employee : empset) {
            if (employee.getId() == id) {
                System.out.println("deleting employee \n" + employee);
                deleteEmp = employee;
                found = true;
            }
        }
        if (!found) {
            System.out.println("Employee not found");
        } else {
            empset.remove(deleteEmp);
        }

    }

    public void displayEmpList() {
        for (Employee employee : empset) {
            System.out.println(employee);
        }
    }

}
