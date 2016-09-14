package lee.zac.BankAccounts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zaclee on 9/13/16.
 */
public class BankAccount {
    static private int counter=1;
    private String accountHolderName;
    private int accountNumber=0;
    private Type accountType;
    private double accountBalance;
    private Status accountStatus;
    private double interestRate; // setters for interest rate?
    private boolean overDraftStatus; // make setters?
    private List accountHistory; // this is going to be an Array List

    public BankAccount(String name, Type type) {
        accountHolderName = name;
        accountNumber = counter;
        accountType = type;
        accountBalance = 0;
        accountStatus = Status.OPEN;
        accountHistory = new ArrayList<String>();
        overDraftStatus = false;
        counter++;
    }

    enum Type { CHECKING, SAVINGS, INVESTMENT }

    enum Status { OPEN, CLOSED, FROZEN }

    public String setAccountHolderName(String name) {
        setAccountHistory("Name changed to: " + name);
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
        overDraftStatus = boo;
        System.out.println("OverDraft Protection Enabled.");
    }

    public void setAccountStatus(Status setStatus) {
        if (accountStatus == Status.CLOSED) { //If status is closed - can't do anything else with status
            System.out.println("Your account is forever closed");
        }
        else { // THis means if your ACC is not already close then :
            if(setStatus == Status.CLOSED && accountBalance == 0) { // if try to close and balance is 0 then close
                accountStatus = setStatus;
                setAccountHistory("Account closed.");
                System.out.println("Your account is closed.");
            }
            else if (setStatus == Status.CLOSED && accountBalance != 0){ // try to close and balance != 0
                System.out.println("Your account balance is not zero.");
                setAccountHistory("Tried to close account, balance not zero.");
            }
            else {
                if (setStatus == Status.FROZEN) {
                    accountStatus = setStatus;
                    System.out.println("The account is frozen.");
                    setAccountHistory("Account frozen.");

                } else if (setStatus == Status.OPEN) {
                    accountStatus = setStatus;
                    System.out.println("The account is open");
                    setAccountHistory("Account opened.");
                }
            }

        }
    }

    public void setAccountHistory(String str) {
        accountHistory.add(str);
    }

    public void showTransactions() {

        for(int i=0; i<accountHistory.size(); i++) {
            System.out.println(accountHistory.get(i));
        }
    }

    public void setInterestRate(double interest) {
        interestRate = interest;
    }

    public double getInterestRate() {
        return interestRate;
    }


}







