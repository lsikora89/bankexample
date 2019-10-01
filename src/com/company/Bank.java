package com.company;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Bank {
    private ArrayList<BankAccount> allAccounts;
    private ArrayList<Customer> allCustomers;

    public Bank(){
        allAccounts = new ArrayList<BankAccount>();
        allCustomers = new ArrayList<Customer>();

    }
    private void printmenu(){
        System.out.println("Please select what to do next:");
        System.out.println("    [1] Add a new Customer");
        System.out.println("    [2] Select Customer for Banking");
        System.out.println("    [3] Remove a Customer from the Bank");
        System.out.println("    [4] Do yearly maintenance (adding interest)");
        System.out.println("    [5] Exit the program");
        System.out.print("Type the number of your selection");
    }

    private Customer addCustomer(Scanner reader){
        System.out.print("Enter new Customers name");
        var name = reader.nextLine();
        System.out.print("What is the new Customers TaxID");
        var taxID = reader.nextInt();
        for (var cust: allCustomers){
            if (cust.getCustomerID() == taxID){
                return cust;
            }
        }
        var newCustomer = new Customer(name, taxID);
        allCustomers.add(newCustomer);
        return newCustomer;
    }
    private Optional<Customer> removeCustomer(Scanner reader){
        System.out.print("Enter tbe taxID of the customer to remove");
        var removeID = reader.nextInt();
        for (var customer: allCustomers){
            if (customer.getCustomerID() == removeID){
                allCustomers.remove(customer);
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }
    
    private void applyInterest(){
        for (var account: allAccounts){
            account.addInterest();


        }

    }


    public void doDailyBanking(){
        var userin = new Scanner(System.in);
        while(true){
            printmenu();
            var userResponse = userin.nextInt();
            userin.nextLine(); //need for trailing \n
            switch (userResponse){
                case 1:
                    var newCust = addCustomer(userin);
                    System.out.println("Customer name:" + newCust.getName() + "" +
                            "TaxID: " + newCust.getCustomerID());
                    break;
                case 3:
                    var oldCustomer = removeCustomer(userin);
                    if(oldCustomer.isPresent())
                        System.out.println("Removed customer" + oldCustomer.get().getName());
                    else
                        System.out.println("There was no Customer with that taxID");

                case 4:
                    applyInterest();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Unknown command");

            }

        }
    }

}
