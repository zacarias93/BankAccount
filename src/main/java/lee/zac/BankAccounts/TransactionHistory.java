package lee.zac.BankAccounts;

import java.util.ArrayList;

/**
 * Created by zaclee on 9/16/16.
 */
public class TransactionHistory {

    private ArrayList<String> transactionHistory = new ArrayList<String>();

    public void showTransactions() {
        System.out.println(transactionHistory.toString());
    }

        public void setAccountHistory(String str) {
            transactionHistory.add(str);
        }
}
