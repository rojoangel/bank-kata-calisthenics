package bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DepositTest {

    @Test
    void should_statically_initialize_a_deposit() {
        LocalDate now = now();
        assertEquals(
                new Deposit(Money.moneyOf(BigDecimal.TEN), now),
                Deposit.depositOf(Money.moneyOf(BigDecimal.TEN), now)
        );
    }
}
