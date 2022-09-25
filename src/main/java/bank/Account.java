package bank;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;

import static bank.Deposit.depositOf;
import static bank.Withdrawal.withdrawalOf;

public class Account {

    private Money balance;

    private final Statement statement;

    public Account(Statement statement) {
        this.balance = Money.moneyOf(BigDecimal.ZERO);
        this.statement = statement;
    }


    public void deposit(Money amount, LocalDate date) {
        balance = balance.add(amount);
        statement.addLine(depositOf(amount, date), balance);
    }

    public void withdraw(Money amount, LocalDate date) {
        balance = balance.substract(amount);
        statement.addLine(withdrawalOf(amount, date), balance);
    }

    public void printStatement(PrintStream printer) {
        statement.printTo(printer);
    }
}
