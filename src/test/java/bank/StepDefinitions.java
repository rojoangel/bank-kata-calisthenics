package bank;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Date;

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
    public void she_would_see(DataTable dataTable) {
        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).println("| date       | credit  | debit  | balance |");
        inOrder.verify(printer).println("| 14/01/2012 |         | 500.00 | 2500.00 |");
        inOrder.verify(printer).println("| 13/01/2012 | 2000.00 |        | 3000.00 |");
        inOrder.verify(printer).println("| 10/01/2012 | 1000.00 |        | 1000.00 |");
    }
}
