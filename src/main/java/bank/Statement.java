package bank;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Date;

public class Statement {
    private static final String HEADER = "| date       | credit  | debit  | balance |";

    public void printTo(PrintStream printer) {
        printer.println(HEADER);
    }

    public void addLine(BigDecimal amount, Date date, BigDecimal balance) {

    }
}
