package model;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import model.enums.AccountType;
import model.enums.Currency;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(int accountNumber, double balance, AccountType type, Currency currency) {
        super(accountNumber, balance,type,currency);
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
if(amount<=0){
    throw new InvalidAmountException("Menfi mebleg daxil edile bilmez !");
}
else if(amount>this.getBalance()){
    throw new InsufficientFundsException("Cixarish meblegi balansdan cox ola bilmez !");
}
else {
    this.setBalance(this.getBalance()-amount);
}
    }
}
