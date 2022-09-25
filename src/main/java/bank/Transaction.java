package bank;

import java.io.PrintStream;
import java.time.format.DateTimeFormatter;

public interface Transaction {
    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    void printTo(PrintStream printer, Money balance);
}
