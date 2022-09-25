package bank;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Statement {

    private final List<StatementLine> lines;
    private static final String HEADER = "| date       | credit  | debit   | balance |";

    public Statement() {
        lines = new ArrayList<>();
    }

    public void addLine(Transaction transaction, Money balance) {
        lines.add(0, new StatementLine(transaction, balance));
    }

    public void printTo(PrintStream printer) {

        printHeader(printer);
        printLines(printer);
    }

    private void printHeader(PrintStream printer) {
        printer.println(HEADER);
    }

    private void printLines(PrintStream printer) {
        for (StatementLine line : lines) {
            line.printTo(printer);
        }
    }
}
