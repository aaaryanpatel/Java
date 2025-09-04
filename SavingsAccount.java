/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalandbank;

/**
 *
 * @author aryan
 */
public class SavingsAccount extends BankAccount {
    private double minBalance;
    private int transactionCount; // no of trans while under min balacne
    private static int ACTIVITY_LIMIT = 3; // how many withdrawals the account can make under min balance
    
    private static double ACTIVITY_PENALTY = 10; // the amount charged when withdrawing after activity limit has been reached

    public SavingsAccount() {
        transctionCount = 0;
    }
    

    public SavingsAccount(double minBalance,  int accountNo, double balance ,Customer customer) {
        super(accountNo, balance, customer);
        this.minBalance = minBalance;
        this.transactionCount = transactionCount;
        this.customer = customer;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }
    
    // not making getter and setter for ACTIVITY_LIMIT and ACTIVITY_PENALTY cause i dont want to change those
    
    public boolean withdraw(double amount) {
        boolean withdrawalSuccessful = false;
        double totalToWithdraw = amount;
            
        // check if account is under min balance 
        if(getBalance() < minBalance) {
            
        
            // keep track of transactions under min balance
            transactionCount++;

            // apply penalty 
            if(transactionCount > ACTIVITY_LIMIT) {
                totalToWithdraw += ACTIVITY_PENALTY;
            }
        }
        
        else {
            // if user withdraw and more than the MB is in account 
            // reset the trans count
            transactionCount = 0;
        }
        
        // if total to withdraw is less than or equal to the balance
        // take money out of the account
        if(totalToWithdraw <= getBalance()) {
            
            setBalance(getBalance() - totalToWithdraw);
            withdrawalSuccessful = true;
        }
        
        return withdrawalSuccessful;
        // create acocount
        // add money 
    }
}
