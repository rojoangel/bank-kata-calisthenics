package bank;

import java.io.PrintStream;
import java.util.Date;

public class Account {
    private final Statement statement;

    public Account(Statement statement) {
        this.statement = statement;
    }


    public void deposit(Money amount, Date date) {
        statement.addLine(amount, date, amount);
    }

    public void withdraw(Money amount, Date date) {
        statement.addLine(amount.negate(), date, amount.negate());
    }

    public void printStatement(PrintStream printer) {
        statement.printTo(printer);
    }
}
