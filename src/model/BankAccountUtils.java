package model;

import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import model.enums.TransactionStatus;

public class BankAccountUtils {
    public static TransactionStatus transfer(BankAccount from, BankAccount to, double amount) throws InvalidAmountException, InsufficientFundsException {
      try {
          if(amount<=0){
              throw new InvalidAmountException("Gonderish 0 ola bilmez !");
          }
          if(amount>from.getBalance()){
              throw new InsufficientFundsException("Balansdan artiq mebleg kocbhurmek mumkun deyil !");
          }
          from.setBalance(from.getBalance()-amount);
          to.setBalance(to.getBalance()+amount);


          System.out.println(amount + " " + from.getCurrency() + " " + from.getAccountNumber() +
                  " hesabından " + to.getAccountNumber() + " hesabına köçürüldü.");
          return TransactionStatus.SUCCESS;
      }
      catch (InsufficientFundsException|InvalidAmountException e){
          System.out.println("Xeta:"+e.getMessage());
          return TransactionStatus.FAILED;
      }
    }
}
