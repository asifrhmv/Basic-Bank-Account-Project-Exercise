package model;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;



public class CheckingAccount extends BankAccount{
    private double overdratfLimit;
    public CheckingAccount(int accountNumber, double balance,double overdratfLimit) {
        super(accountNumber, balance);
        this.overdratfLimit= overdratfLimit;
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
if(amount<=0){
    throw new InvalidAmountException("Mebleg menfi ola bilmez !");
} if (amount>(this.getBalance()+this.overdratfLimit)) {
    throw new InsufficientFundsException("Mebleg balansdan artiq ola bilmez !");
}
this.setBalance(this.getBalance()-amount);
    }
}
