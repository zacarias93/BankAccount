package lee.zac.BankAccounts;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zaclee on 9/13/16.
 */
public class TransactionsTest {

    BankAccount baller1;
    BankAccount baller2;
    Transactions transact;
    double delta;

    @Before
    public void setUpTest(){
        baller1 = new BankAccount("Zac",BankAccount.Type.CHECKING);
        baller2 = new BankAccount("Jalisa",BankAccount.Type.CHECKING);
        transact = new Transactions();
        baller1.setAccountBalance(10);
        baller2.setAccountBalance(20);
        delta= 10^-10;
    }

    @Test
    public void creditTest() {
        transact.creditAccount(baller1,10);
        double expected = 10+10;
        double actual = baller1.getAccountBalance();
        Assert.assertEquals(expected, actual, delta);
    }
    @Test
    public void debitTest() {
        transact.debitAccount(baller1,10);
        double expected = 10-10;
        double actual = baller1.getAccountBalance();
        Assert.assertEquals(expected, actual, delta);
    }
    @Test
    public void transferTest() {// take 10 from baller1 transfer to baller 2 // final values should be 0,30 -- this test Baller 1 to be 0
        transact.transferMoney(baller1,baller2,10);
        double expected = 0;
        double actual = baller1.getAccountBalance();
        Assert.assertEquals(expected,actual,delta);
    }
    @Test
    public void transferTest2() {// take 10 from baller1 transfer to baller 2 // final values should be 0,30 -- this test for baller 2 to be 30
        transact.transferMoney(baller1,baller2,10);
        double expected = 30;
        double actual = baller2.getAccountBalance();
        Assert.assertEquals(expected,actual,delta);
    }


}
