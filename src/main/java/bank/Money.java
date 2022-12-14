package bank;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

public class Money {

    private static final DecimalFormat FORMAT = initFormat();
    private final BigDecimal value;

    private static DecimalFormat initFormat() {
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        format.setGroupingUsed(false);
        return format;
    }

    public Money(BigDecimal value) {
        this.value = value;
    }

    public static Money moneyOf(BigDecimal value) {
        return new Money(value);
    }

    public Money negate() {
        return new Money(value.negate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(value, money.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }

    public Money add(Money otherMoney) {
        return new Money(this.value.add(otherMoney.value));
    }

    public Money substract(Money otherMoney) {
        return new Money(this.value.subtract(otherMoney.value));
    }

    public String format() {
        return FORMAT.format(this.value);
    }
}
