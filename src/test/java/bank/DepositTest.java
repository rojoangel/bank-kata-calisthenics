package bank;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DepositTest {

    @Test
    void should_statically_initialize_a_deposit() {
        assertEquals(
                new Deposit(Money.moneyOf(BigDecimal.TEN), new Date()),
                Deposit.depositOf(Money.moneyOf(BigDecimal.TEN), new Date())
        );
    }
}
