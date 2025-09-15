import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import model.BankAccount;
import model.BankAccountUtils;
import model.CheckingAccount;
import model.SavingsAccount;
import model.enums.AccountType;
import model.enums.Currency;
import model.enums.TransactionStatus;

public class Main {
    public static void main(String[] args) {
try{
    BankAccount savings=new SavingsAccount(101,500, AccountType.SAVINGS, Currency.AZN);
    BankAccount checking =new CheckingAccount(202,400,200,AccountType.CHECKING,Currency.AZN);

    savings.deposit(200);
    checking.deposit(300);

    savings.withdraw(400);
    checking.withdraw(300);

    System.out.println(savings.getBalance());
    System.out.println(checking.getBalance());
    System.out.println(checking.getType());

    System.out.println(savings.getCurrency());


    TransactionStatus status= BankAccountUtils.transfer(savings,checking,200);
    System.out.println(savings.getBalance());
    System.out.println(checking.getBalance());
} catch (InvalidAmountException  | InsufficientFundsException e) {
    System.out.println("Xeta bash verdi:"+e.getMessage());
}
    }
}