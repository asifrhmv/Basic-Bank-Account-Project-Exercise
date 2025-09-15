package model;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import model.enums.AccountType;
import model.enums.Currency;

public abstract class BankAccount {
   private int accountNumber;
    private double balance;
    private AccountType type;
    private Currency currency;

    public BankAccount(int accountNumber, double balance,AccountType type,Currency currency){
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.type=type;
        this.currency=currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public AccountType getType() {
        return this.type;
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
