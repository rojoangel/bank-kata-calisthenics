package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static bank.Money.moneyOf;
import static bank.Withdrawal.withdrawalOf;
import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class WithdrawalTest {

    private PrintStream printer;

    @BeforeEach
    void setUp() {
        printer = mock(PrintStream.class);
    }

    @Test
    void should_statically_build_a_withdrawal() {
        Date now = new Date();
        assertEquals(
                new Withdrawal(moneyOf(TEN), now),
                withdrawalOf(moneyOf(TEN), now)
        );
    }

    @Test
    void should_print_itself() {
        Transaction withdrawal = withdrawalOf(
                moneyOf(BigDecimal.valueOf(500)),
                new Date(14, Calendar.JANUARY, 2012));
        Money balance = moneyOf(BigDecimal.valueOf(25_000));

        withdrawal.printTo(printer, balance);
        verify(printer).println("| 14/01/2012 |         | 500.00 | 2500.00 |");
    }
}
