package lee.zac.BankAccounts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zaclee on 9/13/16.
 */
public class BankAccount {
    static private int counter = 1;
    private String accountHolderName;
    private int accountNumber = 0;
    private Type accountType;
    private double accountBalance;
    private Status accountStatus;
    private double interestRate;
    private boolean overDraftStatus;
    double newBalance;
    double newBalanceAccountTransferredTo;
    double newBalanceAccountTransferredFrom;
    String historyMessage;
    private TransactionHistory history;

    public BankAccount(String name, Type type) {
        accountHolderName = name;
        accountNumber = counter;
        accountType = type;
        accountBalance = 0;
        accountStatus = Status.OPEN;
        overDraftStatus = false;
        counter++;
        history = new TransactionHistory();
    }

    enum Type {CHECKING, SAVINGS, INVESTMENT}

    enum Status {OPEN, CLOSED, FROZEN}

    public TransactionHistory getHistory() {
        return history;
    }

    public String setAccountHolderName(String name) {
        history.setAccountHistory("Name changed to: " + name);
        return accountHolderName = name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double setAccountBalance(double accBal) {
        return accountBalance = accBal;
    }

    public void showAccountBalance() {
        if (accountStatus == Status.FROZEN) {
            System.out.println("This account is frozen. Can not obtain balance at this time.");
        } else {
            System.out.println(getAccountBalance());
        }
    }

    public Status getAccountStatus() {
        return accountStatus;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public boolean getOverdraftStatus() {
        return overDraftStatus;
    }

    public void setOverDraftStatus(boolean boo) {

        if(boo == true) {
            System.out.println("OverDraft Protection Enabled.");
            overDraftStatus = boo;
        }
        else {
            System.out.println("OverDraft Protection Disabled.");
            overDraftStatus = boo;
        }
    }

    public void setAccountStatus(Status setStatus) {
        if (accountStatus == Status.CLOSED) { //If status is closed - can't do anything else with status
            System.out.println("Your account is forever closed");
        } else { // THis means if your ACC is not already close then :
            if (setStatus == Status.CLOSED && accountBalance == 0) { // if try to close and balance is 0 then close
                accountStatus = setStatus;
                history.setAccountHistory("Account closed.");
                System.out.println("Your account is closed.");
            } else if (setStatus == Status.CLOSED && accountBalance != 0) { // try to close and balance != 0
                System.out.println("Your account balance is not zero.");
                history.setAccountHistory("Tried to close account, balance not zero.");
            } else {
                if (setStatus == Status.FROZEN) {
                    accountStatus = setStatus;
                    System.out.println("The account is frozen.");
                    history.setAccountHistory("Account frozen.");

                } else if (setStatus == Status.OPEN) {
                    accountStatus = setStatus;
                    System.out.println("The account is open");
                    history.setAccountHistory("Account opened.");
                }
            }
        }
    }

    public void transactionApprovedMessage() {
        System.out.println("Your transaction was approved. Your new balance is: " + newBalance);
    }

    public void setInterestRate(double interest) {
        interestRate = interest;
        String message = "The interest rate was set to: " + interest;
        System.out.println(message);
        history.setAccountHistory(message);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void creditAccount(double num) {
        if (this.getAccountStatus() == BankAccount.Status.OPEN) {
            newBalance = this.getAccountBalance() + num;
            transactionApprovedMessage();
            this.setAccountBalance(newBalance);
            history.setAccountHistory("You credited " + num + " to your account. ");
        } else {
            System.out.println("This account is not open.");
        }
    }

    public void debitAccount(double num) {
        if (this.getAccountStatus() == BankAccount.Status.OPEN) {

            if ((this.getAccountBalance() < num) && (this.getOverdraftStatus() == true)) {
                System.out.println("OverDraft protection is enabled - this transaction was denied.");
            } else {
                newBalance = this.getAccountBalance() - num;
                transactionApprovedMessage();
                this.setAccountBalance(newBalance);
                history.setAccountHistory("You debited " + num + " from your account. ");
            }
        } else {
            System.out.println("This account is not open.");
        }
    }

    //    You take from the first and add to the second - so check that first has enough to not go negative and go ahead.
    public void transferMoney(BankAccount transferFrom, BankAccount transferTo, double amountTransfer) {

        if (transferFrom.getAccountStatus() == BankAccount.Status.OPEN && transferTo.getAccountStatus() == BankAccount.Status.OPEN && transferFrom.getAccountHolderName() == transferTo.getAccountHolderName()) {

            if ((transferFrom.accountBalance - amountTransfer) < 0 && transferFrom.getOverdraftStatus() == true) {
                System.out.println("You do not have sufficient funds to make this transfer");
            } else {
                newBalanceAccountTransferredTo = transferTo.accountBalance + amountTransfer;
                newBalanceAccountTransferredFrom = transferFrom.accountBalance - amountTransfer;
                transferFrom.setAccountBalance(newBalanceAccountTransferredFrom);
                transferTo.setAccountBalance(newBalanceAccountTransferredTo);
                historyMessage = "You transferred " + amountTransfer + " from " + transferFrom.getAccountHolderName() + " to " + transferTo.getAccountHolderName();
                transferFrom.history.setAccountHistory(historyMessage);
                transferTo.history.setAccountHistory(historyMessage);
                System.out.println(historyMessage);
                System.out.println("New balance for Account 1: " + newBalanceAccountTransferredFrom);
                System.out.println("New balance for Account 2: " + newBalanceAccountTransferredTo);
            }
        }
        else { System.out.println("This account is not open."); }
    }
}







