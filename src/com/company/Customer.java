package com.company;

import java.util.ArrayList;

public class Customer {
    private int customerID;
    private String name;
    private ArrayList<BankAccount> accounts;

    Customer(String name, int taxID){
        accounts=new ArrayList<BankAccount>();
        this.name =name;
        customerID = taxID;
    }

    public boolean openAccount(double initalBalance){
        var newAccount = new BankAccount(initalBalance, 0.02f);
        var success = accounts.add(newAccount);
        return success;
    }

    public BankAccount closeAccount(int bankAccountID){
        BankAccount accountToClose =null;
        for (var account: accounts){
            if (account.getAccountID() == bankAccountID){
                accountToClose = account;
                break;
            }

        }
        accounts.remove(accountToClose);
        return accountToClose;
    }

    public String getName(){
        return (name);
    }

    public int getCustomerID(){
        return customerID;
    }

}

