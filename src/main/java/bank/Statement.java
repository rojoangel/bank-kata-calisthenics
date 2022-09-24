package bank;

import java.io.PrintStream;

public class Statement {
    private static final String HEADER = "| date       | credit  | debit  | balance |";

    public void printTo(PrintStream printer) {
        printer.println(HEADER);
    }

    public void addLine(Transaction transaction, Money balance) {

    }
}
