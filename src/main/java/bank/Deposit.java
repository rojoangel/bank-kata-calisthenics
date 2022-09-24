package bank;

import java.io.PrintStream;
import java.util.Date;
import java.util.Objects;

public class Deposit implements Transaction {
    private final Money money;
    private final Date date;

    public Deposit(Money money, Date date) {
        this.money = money;
        this.date = date;
    }

    public static Transaction depositOf(Money money, Date date) {
        return new Deposit(money, date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return Objects.equals(money, deposit.money) && Objects.equals(date, deposit.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, date);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "money=" + money +
                ", date=" + date +
                '}';
    }

    @Override
    public void printTo(PrintStream printer, Money balance) {

    }
}
