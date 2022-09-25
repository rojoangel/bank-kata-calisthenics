package bank.feature;

import bank.Account;
import bank.Money;
import bank.Statement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class StepDefinitions {

    private Account account;

    private final PrintStream printer = mock(PrintStream.class);

    @Given("a client has an account")
    public void a_client_has_an_account() {
        account = new Account(new Statement());
    }

    @Given("(a client makes )a deposit of {money} on {int}-{int}-{int}")
    public void a_client_makes_a_deposit_of_on(Money amount, Integer day, Integer month, Integer year) {
        account.deposit(amount, LocalDate.of(year, month, day));
    }

    @Given("a withdrawal of {money} on {int}-{int}-{int}")
    public void a_withdrawal_of_on(Money amount, Integer day, Integer month, Integer year) {
        account.withdraw(amount, LocalDate.of(year, month, day));
    }

    @When("she prints her bank statement")
    public void she_prints_her_bank_statement() {
        account.printStatement(printer);
    }

    @Then("she would see")
    public void she_would_see(String docString) {
        InOrder inOrder = inOrder(printer);
        String[] lines = docString.split(System.lineSeparator());
        for (String line : lines) {
            inOrder.verify(printer).println(line);
        }
    }
}
