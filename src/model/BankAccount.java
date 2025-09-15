package model;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;

public abstract class BankAccount {
   private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance){
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }
    public void setAccountNumber(int accountNumber){
        if(accountNumber<0){
            System.out.println("Hesab nomresi menfi ola bilmez !");
        }
        else{
            this.accountNumber=accountNumber;
        }
    }

    public double getBalance(){
        return this.balance;
    }

    protected void setBalance(double balance){
        if(balance<0){
            System.out.println("Balan menfi ola bilmez !");
        }
        else {
            this.balance=balance;
        }
    }

    public void deposit(double amount) throws InvalidAmountException{
        if(amount<=0){
            throw new InvalidAmountException("Deposit meblegi menfi ola bilmez !");
        }
this.balance+=amount;
    }
    public abstract void  withdraw(double amount) throws InvalidAmountException, InsufficientFundsException;

}
