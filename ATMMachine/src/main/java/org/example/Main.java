package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATMOperationInterface op = new ATMOperationImpl();
        int atmNumber = 1234;
        int atmPin = 123;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to ATM Machine !!!");
        System.out.print("Enter Atm Number : ");
        int atmNum = sc.nextInt();
        System.out.println("Enter atm pin");
        int atmPi = sc.nextInt();
        if (atmNum == atmNumber && atmPi == atmPin) {
            while (true) {
                System.out.println("1.View Available Balance\n2.Withdraw Amount\n3.Deposit Amount\n4.View Ministatement\n5.Exit");
                System.out.println("Enter Choice : ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        op.viewBalance();
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw ");
                        double withdrawAmount = sc.nextDouble();
                        op.withdrawAmount(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Enter Amount to Deposit :");
                        double depositAmount = sc.nextDouble();//5000
                        op.depositAmount(depositAmount);
                        break;
                    case 4:
                        op.viewMiniStatement();
                        break;
                    case 5:
                        System.out.println("Collect your ATM Card\n Thank you for using ATM Machine!!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Please enter correct choice");
                        break;
                }
            }
        } else {
            System.out.println("Incorrect details");
            System.exit(0);
        }
    }
}