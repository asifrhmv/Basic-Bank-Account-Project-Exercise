package model;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import model.enums.AccountType;
import model.enums.Currency;


public class CheckingAccount extends BankAccount{
    private double overdratfLimit;
    public CheckingAccount(int accountNumber, double balance, double overdratfLimit, AccountType type, Currency currency) {
        super(accountNumber, balance,type,currency);
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
