package org.example;


import java.util.Scanner;

public class Main {


    static boolean ordering = true;

    public static void menu() {
        System.out.println("\n=====Welcome to Emp System=====" +
                "\n 1.Add Employee" +
                "\n 2.View Employee" +
                "\n 3.Update Employee" +
                "\n 4.Delete Employee" +
                "\n 5.Display Emp List" +
                "\n 6.Exit");
    }

    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        Scanner sc = new Scanner(System.in);

        do {
            menu();
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add Employee");
                    service.addEmp();
                    break;
                case 2:
                    System.out.println("View Employee");
                    service.getEmpById();
                    break;
                case 3:
                    System.out.println("Update Employee");
                    service.updateEmployee();
                    break;
                case 4:
                    System.out.println("Delete Employee");
                    service.deleteEmployee();
                    break;
                case 5:
                    System.out.println("Display Employee List");
                    service.displayEmpList();
                    break;
                case 6:
                    System.out.println("Thank you");
                    System.exit(0);
                default:
                    System.out.println("Please enter valid choice");
                    break;

            }
        } while (ordering);

    }
}