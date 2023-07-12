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
        bankAccount.setDateOfBirth("24/12/1997");
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
    public void canGetLastName(){
        //When
        String actual  = bankAccount.getLastName();
        //Then
        String expected = "Ahmed";

        assertThat(actual).isEqualTo(expected);

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
    public void canGetAccountNumber(){
        //When
        int actual  = bankAccount.getAccountNumber();
        //Then
        int expected = 101010;

        assertThat(actual).isEqualTo(expected);

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
    public void canWithdrawWithOverdraft(){
        // Withdraw more than overdraft limit
        bankAccount.withdraw(200);

        //When
        double actual = bankAccount.getBalance();
        //Then (add if statements)
        double expected = 50;

        assertThat(actual).isEqualTo(expected);

    }




}
