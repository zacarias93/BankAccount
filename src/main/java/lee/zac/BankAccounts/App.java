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
        BankAccount baller2 = new BankAccount("Zac", BankAccount.Type.INVESTMENT);

        baller1.creditAccount(50);
        baller1.debitAccount(20);
        baller1.transferMoney(baller1,baller2,20);
        baller1.setOverDraftStatus(false);
        baller1.setOverDraftStatus(true);


        baller1.transferMoney(baller1,baller2,20d);
        System.out.println(baller1.getAccountBalance());
        System.out.println(baller2.getAccountBalance());




        baller2.getHistory().showTransactions();
        System.out.println();
        baller1.getHistory().showTransactions();

        baller1.transferMoney();


    }
}
