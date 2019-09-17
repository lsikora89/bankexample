package com.company;

public class bankexample {
    private double balance;
    private float interestRate;

    public void deposit(double amount) {
        balance+=amount;
    }
    public boolean withdraw(double amount) {
        if (balance>=amount){
            balance-=amount;
        }
        return false;
    }
}
