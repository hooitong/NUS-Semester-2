/**
 * This program acts as a bank, allowing each person to withdraw or deposit money
 * @author Yeap Hooi Tong
 * @matric A0111736M
 * @date 06/09/13
 * @version 1.0
 */

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

class Person {

    // declare the necessary variables for the user
    private String user;
    private double balance;

    // overriding constructor
    public Person(String user, double balance) {
        this.user = user;
        this.balance = balance;
    }

    /**
     * This method is used to withdraw money from the account
     * which is technically removing money from the user
     *
     * @param money the amount of money that is soon to be withdrawn
     * @return boolean whether the operation has been successfully completed
     * @pre money must not be negative
     */
    public boolean withdrawMoney(double money) {
        if (this.balance < money) return false; // not enough money to withdraw
        this.balance -= money; // deduct the money from the user
        return true;
    }

    /**
     * This method is used to deposit money into the account
     *
     * @param money the amount of money that is deposited into his account
     * @return boolean whether the operation has been successfully completed
     * @pre money must not be negative
     */
    public boolean depositMoney(double money) {
        this.balance += money;
        return true;
    }

    // declare the necessary getters
    public String getUser() {
        return user;
    }

    public double getBalance() {
        return balance;
    }
}

public class Bank {
    // declare the class variables
    int interestRate, period; // the interest rate % per annum and the period in months
    ArrayList<Person> customerDB = new ArrayList<Person>(); // array list to store all the customer in the bank

    /**
     * Read the input from the user appropriately and operate the bank
     * by accepting the function and amount from user.
     */
    public void operateBank() {
        // create scanner object
        Scanner sc = new Scanner(System.in);
        String operation = "";

        // accept interest rate and period from user
        interestRate = sc.nextInt();
        period = sc.nextInt();

        // while user does not press 0 to terminate
        do {
            // read in user's operation
            operation = sc.next();
            if (operation.equals("0")) break;
            // read in username
            String user = sc.next();

            // read in the amount of money
            double money = sc.nextDouble();

            // based on the operation given by the user, call the necessary functions
            if (operation.equals("Create")) createAccount(user, money); // create account
            else if (operation.equals("Deposit")) findCustomer(user).depositMoney(money); // deposit money
            else if (operation.equals("Withdraw")) findCustomer(user).withdrawMoney(money); // withdraw money

        } while (sc.hasNext());  // when 0 is given, the application is terminated

        // bank is closed
    }

    /**
     * This method is used to create an account for the user
     *
     * @param user  the name of the person
     * @param money the amount of money in his account
     * @pre money must not be null or less than 0, user must not be null
     */
    private void createAccount(String user, double money) {
        // create a new account and add into the array list
        customerDB.add(new Person(user, money + calculateInterest(money)));
    }

    /**
     * This method is used to calculate the interest based on bank information
     * and return the acquired interest.
     *
     * @param money the initial deposit
     * @return the interest in double data type
     * @pre money must not be negative
     */
    private double calculateInterest(double money) {
        return money * ((interestRate / 100.0) / 12.0) * period;
    }

    /**
     * This method is used to find the customer object from the database and return
     *
     * @param user the name of the person
     * @return the matched person object or null if not found
     * @pre user must not be null
     */
    private Person findCustomer(String user) {
        for (Person p : customerDB) {
            if (p.getUser().equals(user)) return p;
        }
        return null;
    }

    /**
     * This method is used when the bank closes and it prints out the
     * number of accounts registered in the bank as well as the information of each account.
     */
    private void closeBank() {
        // print out the number of accounts
        System.out.println(customerDB.size());
        // create DecimalFormat object to format to 2 decimal place
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        // print out information of each customer
        for (Person p : customerDB) {
            System.out.println(p.getUser() + " " + df.format(p.getBalance()));
        }
    }

    public static void main(String[] args) {
        Bank POSB = new Bank(); // create a new bank object
        POSB.operateBank(); // call the method to operate the bank
        POSB.closeBank(); // called when the bank closes and print out summary
        System.exit(0); // end the application when the bank is closed
    }
}
