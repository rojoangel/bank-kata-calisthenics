package bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static bank.Money.moneyOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {

    public static final BigDecimal TEN_THOUSAND = BigDecimal.valueOf(10_000);
    public static final BigDecimal NEGATIVE_TEN_THOUSAND = BigDecimal.valueOf(10_000).negate();

    @Test
    void should_statically_initialize_a_money() {
        assertEquals(
                new Money(TEN_THOUSAND),
                moneyOf(TEN_THOUSAND));
    }

    @Test
    void should_return_the_negative_value() {
        assertEquals(
                new Money(NEGATIVE_TEN_THOUSAND),
                moneyOf(TEN_THOUSAND).negate()
        );
    }
}
