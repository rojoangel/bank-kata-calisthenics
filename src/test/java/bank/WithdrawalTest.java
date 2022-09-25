package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;

import static bank.Money.moneyOf;
import static bank.Withdrawal.withdrawalOf;
import static java.math.BigDecimal.TEN;
import static java.time.LocalDate.now;
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
        LocalDate now = now();
        assertEquals(
                new Withdrawal(moneyOf(TEN), now),
                withdrawalOf(moneyOf(TEN), now)
        );
    }

    @Test
    void should_print_itself() {
        Transaction withdrawal = withdrawalOf(
                moneyOf(BigDecimal.valueOf(500)),
                LocalDate.of(2012, 1, 14));
        Money balance = moneyOf(BigDecimal.valueOf(25_000));

        withdrawal.printTo(printer, balance);
        verify(printer).println("| 14/01/2012 |         | 500.00 | 2500.00 |");
    }
}
