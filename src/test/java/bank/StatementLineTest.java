package bank;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static bank.Money.moneyOf;
import static java.math.BigDecimal.TEN;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class StatementLineTest {

    @Test
    void should_print_itself() {
        Transaction transaction = spy(Transaction.class);
        PrintStream printer = mock(PrintStream.class);
        Money balance = moneyOf(TEN);
        StatementLine line = new StatementLine(transaction, balance);

        line.printTo(printer);
        verify(transaction).printTo(printer, balance);
    }
}
