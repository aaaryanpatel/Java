/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javalandbank;

/**
 *
 * @author aryan
 */
public class CheckingAccount extends BankAccount {

    
    private double overdraftLimit;
    private double overdraftPenalty;
    
    
    
    public double getOverDraftLimit() {
        return overdraftLimit;
    }

    public double getOverDraftPenalty() {
        return overdraftPenalty;
    }

    public void setOverDraftLimit(double overDraftLimit) {
        this.overdraftLimit = overDraftLimit;
    }

    public void setOverDraftPenalty(double overDraftPenalty) {
        this.overdraftPenalty = overDraftPenalty;
    }
    
    
    
    
    @Override
    public boolean withdraw(double amount) {
        
        // track fi the accoumt was able to withdraw the money
        boolean canWithdraw = false;
        boolean addPenalty = false;
        
        // check if the account is allowed to withdraw that much money
        // 45 + 5 <= -55 + 100
        // check of amount can be withdrawn with the overdraft penalty
        // make sure to factor in the overfraftLimit
        if(amount + overdraftPenalty <= getBalance()  + overdraftLimit) {
            canWithdraw = true;
        }
        
        
        if(canWithdraw) {
            // check if overdraft;
            // 100 - 105 = -5 < 0
            if(getBalance() - amount < 0) {
                // add an overdraft penalty
                addPenalty = true;
            }
            
        }
        
        // substract amount from balance
        if(canWithdraw) {
           
           // set balance to the current balance minus the withdraw amount
           setBalance( getBalance() - amount);
           
           if(addPenalty) {
               
               // set balance to the balance (after withdrawal) minus the overdraft penalty
               setBalance(getBalance() - overdraftPenalty);
           }
        }
     
        return canWithdraw;
    }
    
    
    // SAVINGS 
    // - minimum balance
    // - if it goes below the MB a countdown starts k
    // 
    
    //  fill out withdraw function
    
}
