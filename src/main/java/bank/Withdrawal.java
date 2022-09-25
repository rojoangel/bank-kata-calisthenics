package bank;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Objects;

public class Withdrawal implements Transaction {
    private final Money money;
    private final LocalDate date;

    public Withdrawal(Money money, LocalDate date) {
        this.money = money;
        this.date = date;
    }

    public static Transaction withdrawalOf(Money money, LocalDate date) {
        return new Withdrawal(money, date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Withdrawal that = (Withdrawal) o;
        return Objects.equals(money, that.money) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, date);
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "money=" + money +
                ", date=" + date +
                '}';
    }

    @Override
    public void printTo(PrintStream printer, Money balance) {
        String output = String.format("| %s | %s | %s | %s |", formatDate(), formatCredit(), formatDebit(), formatBalance(balance));
        printer.println(output);
    }

    private String formatBalance(Money balance) {
        return balance.format();
    }

    private String formatDebit() {
        return this.money.format();
    }

    private String formatCredit() {
        return "       ";
    }

    private String formatDate() {
        return DATE_TIME_FORMATTER.format(this.date);
    }
}
