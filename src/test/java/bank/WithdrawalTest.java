package bank;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static bank.Money.moneyOf;
import static bank.Withdrawal.withdrawalOf;
import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.*;

class WithdrawalTest {

    @Test
    void should_statically_build_a_withdrawal() {
        assertEquals(
                new Withdrawal(moneyOf(TEN), new Date()),
                withdrawalOf(moneyOf(TEN), new Date())
        );
    }
}
