package bank;

import java.io.PrintStream;
import java.util.Date;

public class Account {
    private final Statement statement;

    public Account(Statement statement) {
        this.statement = statement;
    }


    public void deposit(Money money, Date date) {
        statement.addLine(money, date, money);
    }

    public void withdraw(Money amount, Date date) {

    }

    public void printStatement(PrintStream printer) {
        statement.printTo(printer);
    }
}
