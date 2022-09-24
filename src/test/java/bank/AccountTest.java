package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static bank.Deposit.depositOf;
import static bank.Withdrawal.withdrawalOf;
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
        Money amount = Money.moneyOf(BigDecimal.valueOf(10_000));
        Date date = new Date(1, Calendar.OCTOBER, 2022);

        account.deposit(amount, date);
        verify(statement).addLine(depositOf(amount, date), amount);
    }

    @Test
    void should_add_withdrawal_line_to_statement() {
        Money amount = Money.moneyOf(BigDecimal.valueOf(10_000));
        Date date = new Date(1, Calendar.OCTOBER, 2022);

        account.withdraw(amount, date);
        verify(statement).addLine(withdrawalOf(amount, date), amount.negate());
    }
}
