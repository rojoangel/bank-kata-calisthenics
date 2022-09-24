package bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static bank.Money.moneyOf;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void should_statically_initialize_a_money() {
        assertEquals(
                new Money(BigDecimal.valueOf(10_000)),
                moneyOf(BigDecimal.valueOf(10_000)));
    }
}
