import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankAccount {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int accountNumber;
    private double balance;
    private String accountType;
    private double overdraft;

    public BankAccount(){
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = LocalDate.now();
        this.accountNumber = 0;
        this.balance = 0;
        this.accountType = "";
        this.overdraft = 0;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public void deposit(double amount){
        this.balance += amount;
    }
    public void withdraw(double amount){
        if((amount) <= (this.balance + this.overdraft)){
            this.balance -= amount;
        }else{
            System.out.println("Cannot Exceed Overdraft Amount");
        }

    }

    public void payInterest() {

        if (this.accountType.equalsIgnoreCase("current")){
            this.balance += ((10.0 / 100.0) * 100.0);

        } else if (this.accountType.equalsIgnoreCase("saving")) {
            this.balance += ((5.0 / 100) * 100.0);

        } else if (this.accountType.equalsIgnoreCase("credit")) {
            this.balance += ((15.0 / 100) * 100.0);
        }
    }
}
