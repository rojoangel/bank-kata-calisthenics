package bank;

import java.io.PrintStream;

public class StatementLine {
    private final Transaction transaction;
    private final Money balance;

    public StatementLine(Transaction transaction, Money balance) {
        this.transaction = transaction;
        this.balance = balance;
    }

    public void printTo(PrintStream printer) {
        this.transaction.printTo(printer, balance);
    }
}
