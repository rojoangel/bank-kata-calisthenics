package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;

import static bank.Deposit.depositOf;
import static bank.Money.moneyOf;
import static bank.Withdrawal.withdrawalOf;
import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class DepositTest {

    private PrintStream printer;

    @BeforeEach
    void setUp() {
        printer = mock(PrintStream.class);
    }

    @Test
    void should_statically_initialize_a_deposit() {
        LocalDate now = now();
        assertEquals(
                new Deposit(Money.moneyOf(BigDecimal.TEN), now),
                depositOf(Money.moneyOf(BigDecimal.TEN), now)
        );
    }

    @Test
    void should_print_itself() {
        Transaction deposit = depositOf(
                moneyOf(BigDecimal.valueOf(2_000)),
                LocalDate.of(2012, 1, 13));
        Money balance = moneyOf(BigDecimal.valueOf(3_000));

        deposit.printTo(printer, balance);
        verify(printer).println("| 13/01/2012 | 2000.00 |        | 3000.00 |");
    }
}
