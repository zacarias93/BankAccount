package lee.zac.BankAccounts;

/**
 * Created by zaclee on 9/13/16.
 */
public class App {

//    Things I need to do still -
//    History of changes
//    credit / debit / transfer
//    changes to : status / name / interest rate







    public static void main(String[] args) {
        BankAccount baller1 = new BankAccount("Zac", 001, BankAccount.Type.CHECKING);
        BankAccount baller2 = new BankAccount("Grace", 002, BankAccount.Type.SAVINGS);
        Transactions transact = new Transactions();
        transact.creditAccount(baller1,50);
        transact.creditAccount(baller2,20);
        transact.creditAccount(baller1,20);
        transact.debitAccount(baller1,70);
        baller1.setAccountStatus(BankAccount.Status.FROZEN);
        baller1.showAccountBalance();
        baller1.setAccountHolderName("Zachary");
        baller1.setAccountStatus(BankAccount.Status.OPEN);
        baller1.setAccountStatus(BankAccount.Status.CLOSED);

        System.out.println();

        baller1.showTransactions();

        System.out.println();

        transact.debitAccount(baller1,20);
        transact.transferMoney(baller1,baller2,20);
        transact.creditAccount(baller2,30);
        transact.debitAccount(baller2,20);
        baller2.setAccountStatus(BankAccount.Status.CLOSED);
        baller1.setAccountStatus(BankAccount.Status.OPEN);
        baller1.setAccountStatus(BankAccount.Status.FROZEN);
        System.out.println();
        baller1.showTransactions();
        System.out.println();
        baller2.showTransactions();






    }
}
