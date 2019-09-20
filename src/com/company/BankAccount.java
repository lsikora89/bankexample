package com.company;

public class BankAccount {
    private double balance;
    private float interestRate;
    private int accountID;
    private static int nextID= 1000;

    public BankAccount(){
        interestRate = 0.02f;
        accountID = nextID;
        nextID+= 1;

    }
    public BankAccount(double intialBalance, float initialIntrest){
        balance = intialBalance;
        interestRate= initialIntrest;
        accountID = nextID;
        nextID++;
    }

    public void deposit(double amount) {
        balance+=amount;
    }
    public boolean withdraw(double amount) {
        if (balance>=amount){
            balance-=amount;
        }
        return false;
    }
    public double checkBalance() {
        return balance;
    }
        public int getAccountID(){
            return accountID;
    }
    public double addInterest(){
        balance += balance*interestRate;
        return balance;
    }
}
