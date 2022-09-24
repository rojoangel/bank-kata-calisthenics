package bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepositTest {

    @Test
    void should_statically_initialize_a_deposit() {
        Date now = new Date();
        assertEquals(
                new Deposit(Money.moneyOf(BigDecimal.TEN), now),
                Deposit.depositOf(Money.moneyOf(BigDecimal.TEN), now)
        );
    }
}
