package bank;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Date;

public class Account {
    private final Statement statement;

    public Account() {
        statement = new Statement();
    }

    public void deposit(BigDecimal amount, Date date) {
    }

    public void withdraw(BigDecimal amount, Date date) {

    }

    public void printStatement(PrintStream printer) {
        statement.printTo(printer);
    }
}
