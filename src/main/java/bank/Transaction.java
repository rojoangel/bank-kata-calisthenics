package bank;

import java.io.PrintStream;

public interface Transaction {
    void printTo(PrintStream printer, Money balance);
}
