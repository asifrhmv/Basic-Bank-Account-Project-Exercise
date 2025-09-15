import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountException;
import model.BankAccount;
import model.CheckingAccount;
import model.SavingsAccount;

public class Main {
    public static void main(String[] args) {
try{
    BankAccount savings=new SavingsAccount(101,500);
    BankAccount checking =new CheckingAccount(202,400,200);

    savings.deposit(200);
    checking.deposit(300);

    savings.withdraw(400);
    checking.withdraw(300);

    System.out.println(savings.getBalance());
    System.out.println(checking.getBalance());
} catch (InvalidAmountException  | InsufficientFundsException e) {
    System.out.println("Xeta bash verdi:"+e.getMessage());
}
    }
}