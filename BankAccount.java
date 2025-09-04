/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalandbank;

/**
 *
 * @author aryan
 */
public abstract class BankAccount {
    
    private int accountNo;
    // pivate Customer customer
    private double balance;
    
    
    // constructor are special functions with no return 
    
    public BankAccount() {
        
        // default values
        accountNo = 9999;
        balance = 0;
    }
    
    public BankAccount(int accountNo, double balance) {
        
        
        this.accountNo = accountNo;
        
        this.balance = balance;
    }
    
    public int getAccountNo() {
        return accountNo;
    }
    
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
    
    public void deposit(double amount) {
        
        balance = balance + amount;
    }
    
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    /**
     * Takes money out of this account and deposit it in another account 
     * @param inAccount => The account reciving the money
     * @param amount => the amount of money to transfer
     * @return return true if the transfer was successful
     */
    
    
    // alows user to 
    public abstract boolean withdraw(double amount);
    
    public boolean Transfer(BankAccount inAccount, double amount) {
        boolean withdrawSuccess = true;
        
       withdrawSuccess =  withdraw(amount);
        
        
        // if the user have money
        if(withdrawSuccess) {
            
             // inaccount.   means whatever accounts  gets passed in
            inAccount.deposit(amount);  
            
        }
        
        
        
        return withdrawSuccess;
    }
    
    
}
