import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountTest {

    BankAccount bankAccount;

    @BeforeEach
    public void setUp(){
        bankAccount = new BankAccount();
        bankAccount.setFirstName("Tarek");
        bankAccount.setLastName("Ahmed");
        bankAccount.setAccountNumber(101010);
        bankAccount.setDateOfBirth("24/12/1997"); // takes in String Then Parses to LocalDate
        bankAccount.setBalance(50);
        bankAccount.setAccountType("Current");
        bankAccount.setOverdraft(100);

    }

    @Test
    public void canGetFirstName(){
        //When
        String actual  = bankAccount.getFirstName();
        //Then
        String expected = "Tarek";

        assertThat(actual).isEqualTo(expected);

    }
    @Test
    public void canSetFirstName(){
        String setFirstName = "Bright";
        bankAccount.setFirstName(setFirstName);

        String actual  = bankAccount.getFirstName();

        assertThat(actual).isEqualTo(setFirstName);


    }
    @Test
    public void canGetLastName(){
        //When
        String actual  = bankAccount.getLastName();
        //Then
        String expected = "Ahmed";

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void canSetLastName(){
        String setLastName = "Network";
        bankAccount.setLastName(setLastName);

        String actual  = bankAccount.getLastName();

        assertThat(actual).isEqualTo(setLastName);


    }


    @Test
    public void canGetDOB(){
        //When
        LocalDate actual  = bankAccount.getDateOfBirth();
        //Then
        LocalDate expected = LocalDate.of(1997,12,24);

        assertThat(actual).isEqualTo(expected);

    }
    @Test
    public void canSetDOB(){
        String SetDOB = "24/12/1997";
        bankAccount.setDateOfBirth(SetDOB);

        LocalDate actual  = bankAccount.getDateOfBirth();

        assertThat(actual).isEqualTo(LocalDate.of(1997,12,24));

    }


    @Test
    public void canGetAccountNumber(){
        //When
        int actual  = bankAccount.getAccountNumber();
        //Then
        int expected = 101010;

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void canSetAccountNumber(){

        int setAccountNumber = 111111;
        bankAccount.setAccountNumber(setAccountNumber);

        double actual  = bankAccount.getAccountNumber();

        assertThat(actual).isEqualTo(setAccountNumber);


    }

    @Test
    public void canGetBalance(){
        //When
        double actual  = bankAccount.getBalance();
        //Then
        double expected = 50.0;

        assertThat(actual).isEqualTo(expected);

    }
    @Test
    public void canSetBalance(){
        double setBalanceAmount = 150;
        bankAccount.setBalance(setBalanceAmount);

        double actual  = bankAccount.getBalance();

        assertThat(actual).isEqualTo(setBalanceAmount);


    }
    @Test
    public void canGetAccountType(){
        String actual = bankAccount.getAccountType();
        String expected = "Current";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canSetAccountType(){
        String accountType = "Premium";

        bankAccount.setAccountType(accountType);

        String actual = bankAccount.getAccountType();

        assertThat(actual).isEqualTo(actual);
    }
    @Test
    public void canGetOverdraft(){
        //When
        double actual  = bankAccount.getBalance();
        //Then
        double expected = 50.0;

        assertThat(actual).isEqualTo(expected);


    }
    @Test
    public void canSetOverdraft(){
        double setOverdraftAmount = 150;

        bankAccount.setOverdraft(setOverdraftAmount);
        double actual  = bankAccount.getOverdraft();

        assertThat(actual).isEqualTo(setOverdraftAmount);


    }

    @Test
    public void canDeposit(){
        // initialize temp variables
        double depositAmount = 50.0;

        // deposit the Amount
        bankAccount.deposit(depositAmount);

        //When
        double actual = bankAccount.getBalance();
        //Then
        double expected = 100;

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void canWithdraw(){
        // initialize temp variables
        double withdrawAmount = 50.0;

        // withdraw the Amount
        bankAccount.withdraw(withdrawAmount);

        //When
        double actual = bankAccount.getBalance();
        //Then
        double expected = 0;

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void canPayInterest(){
        // pay interest
        bankAccount.payInterest();

        //When
        double actual = bankAccount.getBalance();
        //Then (add if statements)
        double expected = 60;

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void canWithdrawWithInOverdraftLimit(){
        //Declare Temp Variables
        double amount = 125;
        double balanceBeforeWithdraw = bankAccount.getBalance();

        // Withdraw more than overdraft limit
        bankAccount.withdraw(amount);

        //When
        double balanceAfterWithdraw = bankAccount.getBalance();
        //Then
        double expected = balanceBeforeWithdraw - amount ;

        assertThat(balanceAfterWithdraw).isEqualTo(expected);

    }


    @Test
    public void cantWithdrawMoreThanOverdraftLimit(){

        double BalanceBeforeWithdraw = bankAccount.getBalance();

        // Withdraw more than overdraft limit
        bankAccount.withdraw(200);

        double actual = bankAccount.getBalance();

        assertThat(actual).isEqualTo(BalanceBeforeWithdraw);

    }




}
