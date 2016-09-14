package lee.zac.BankAccounts;

/**
 * Created by zaclee on 9/13/16.
 */
public class App {

//    To Do List
//   document change if changing interest rate - add it
//     Can only change if acc's have 'same acc name'



    public static void main(String[] args) {
        BankAccount baller1 = new BankAccount("Zac", BankAccount.Type.CHECKING);
        BankAccount baller2 = new BankAccount("Grace", BankAccount.Type.SAVINGS);
        BankAccount baller3 = new BankAccount("Zac", BankAccount.Type.SAVINGS);
        Transactions transact = new Transactions();
        transact.creditAccount(baller1,50);
        transact.transferMoney(baller1,baller3,10);
        transact.creditAccount(baller2,20);
        transact.creditAccount(baller1,20);
        transact.debitAccount(baller1,70);
        transact.transferMoney(baller2,baller1,15);
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
