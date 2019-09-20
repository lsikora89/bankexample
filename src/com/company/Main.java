package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var account = new BankAccount();
        var comp152acct = new BankAccount(10000, 0.05f);
        var account2 = new BankAccount(10000, 0.05f);
        account.deposit(1000);
        account.addInterest();
        var succeeded = account.withdraw(2000);
        if(succeeded)
            System.out.println("You mange to withdraw");
        else
            System.out.println("You can't withdraw 2000 when you" +
                    "only have" + account.checkBalance());

        account2.addInterest();
        System.out.println("The second account (account ID "+ account2.getAccountID()+ ") has "+account2.checkBalance() + " after interest added");
        account2.withdraw(5000); //note that I'm ignoring the boolean return value
        System.out.println("The second account balance after withdraw:"+ account2.checkBalance());

    }
}
