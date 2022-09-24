package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class AccountTest {

    private Account account;
    private Statement statement;

    @BeforeEach
    void setUp() {
        statement = spy(Statement.class);
        account = new Account(statement);
    }

    @Test
    void should_add_deposit_line_to_statement() {
        account.deposit(BigDecimal.valueOf(1_000), new Date(1, Calendar.OCTOBER, 2022));
        verify(statement).addLine(BigDecimal.valueOf(1_000), new Date(1, Calendar.OCTOBER, 2022), BigDecimal.valueOf(1_000));
    }
}
