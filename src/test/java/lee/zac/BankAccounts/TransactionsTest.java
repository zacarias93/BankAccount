package lee.zac.BankAccounts;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zaclee on 9/13/16.
 */
public class TransactionsTest {

    BankAccount baller;
    BankAccount baller1;
    Transactions transact;
    double delta;

    @Before
    public void setUpTest(){
        baller = new BankAccount("Zac",1,BankAccount.Type.CHECKING);
        baller1 = new BankAccount("Jalisa",2,BankAccount.Type.CHECKING);
        transact = new Transactions();
        delta= 10^-10;
    }

//    @Test
//    public void creditTest() { // Baller is initialized to 0 - so 0+10 = 10
//        double expected = 10;
//        double actual = transact.creditAccount(baller,10);
//        Assert.assertEquals(expected, actual, delta);
//    }
//    @Test
//    public void debitTest() { // Baller is initialized to 0 - so 10-10 = 0
//        baller.setAccountBalance(10);
//        double expected = 0;
//        double actual = transact.debitAccount(baller,10);
//        Assert.assertEquals(expected, actual, delta);
//    }


}
