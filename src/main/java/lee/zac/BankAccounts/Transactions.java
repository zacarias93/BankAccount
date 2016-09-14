package lee.zac.BankAccounts;

/**
 * Created by zaclee on 9/13/16.
 */
public class Transactions {

    double newBalance;
    double newBalanceAccountTransferredTo;
    double newBalanceAccountTransferredFrom;
    String historyMessage;


    public void transactionApprovedMessage() {
        System.out.println("Your transaction was approved. Your new balance is: " + newBalance);
    }

    public void creditAccount(BankAccount bankAccount, double num) {
        if(bankAccount.getAccountStatus() == BankAccount.Status.OPEN) {
            newBalance = bankAccount.getAccountBalance() + num;
            transactionApprovedMessage();
            bankAccount.setAccountBalance(newBalance);
            bankAccount.setAccountHistory("You credited " + num + " to your account. ");
        }
        else { System.out.println("This account is not open."); }
    }

    public void debitAccount(BankAccount bankAccount, double num) {
        if(bankAccount.getAccountStatus() == BankAccount.Status.OPEN) {

            if ((bankAccount.getAccountBalance() < num) && (bankAccount.getOverdraftStatus() == true)) {
                System.out.println("OverDraft protection is enabled - this transaction was denied.");
            } else {
                newBalance = bankAccount.getAccountBalance() - num;
                transactionApprovedMessage();
                bankAccount.setAccountBalance(newBalance);
                bankAccount.setAccountHistory("You debited " + num + " from your account. ");
            }
        }
        else { System.out.println("This account is not open."); }
    }
    //You take from the first and add to the second - so check that first has enough to not go negative and go ahead.
    public void transferMoney(BankAccount transferFrom, BankAccount transferTo, double amountTransfer) {

        if (transferFrom.getAccountStatus() == BankAccount.Status.OPEN && transferTo.getAccountStatus() == BankAccount.Status.OPEN) {

            if ((transferFrom.getAccountBalance() - amountTransfer) < 0) {
                System.out.println("You do not have sufficient funds to make this transfer");
            } else {
                newBalanceAccountTransferredTo = transferTo.getAccountBalance() + amountTransfer;
                newBalanceAccountTransferredFrom = transferFrom.getAccountBalance() - amountTransfer;
                transferFrom.setAccountBalance(newBalanceAccountTransferredFrom);
                transferTo.setAccountBalance(newBalanceAccountTransferredTo);
                historyMessage = "You transferred " + amountTransfer + " from " + transferFrom.getAccountHolderName() + " to " + transferTo.getAccountHolderName();
                transferFrom.setAccountHistory(historyMessage);
                transferTo.setAccountHistory(historyMessage);
                System.out.println(historyMessage);
                System.out.println("New balance for Account 1: " + newBalanceAccountTransferredFrom);
                System.out.println("New balance for Account 2: " + newBalanceAccountTransferredTo);
            }
        }
        else { System.out.println("This account is not open."); }
    }

}

