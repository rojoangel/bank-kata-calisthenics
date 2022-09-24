package bank;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Date;

public class StepDefinitions {

    private Account account;

    private PrintStream printer;

    @Given("a client has an account")
    public void a_client_has_an_account() {
        account = new Account();
    }

    @Given("a client makes a deposit of {bigdecimal} on {int}-{int}-{int}")
    public void a_client_makes_a_deposit_of_on(BigDecimal amount, Integer day, Integer month, Integer year) {
        account.deposit(amount, new Date());
    }

    @Given("a deposit of {bigdecimal} on {int}-{int}-{int}")
    public void a_deposit_of_on(BigDecimal amount, Integer day, Integer month, Integer year) {
        account.deposit(amount, new Date());
    }

    @Given("a withdrawal of {bigdecimal} on {int}-{int}-{int}")
    public void a_withdrawal_of_on(BigDecimal amount, Integer day, Integer month, Integer year) {
        account.withdraw(amount, new Date());
    }

    @When("she prints her bank statement")
    public void she_prints_her_bank_statement() {
        account.printStatement(printer);
    }

    @Then("she would see")
    public void she_would_see(io.cucumber.datatable.DataTable dataTable) {
    }

}
