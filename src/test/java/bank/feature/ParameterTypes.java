package bank.feature;

import bank.Money;
import io.cucumber.java.ParameterType;

import java.math.BigDecimal;

import static bank.Money.moneyOf;

public class ParameterTypes {

    @ParameterType(".*")
    public Money money(String amount) {
        return moneyOf(new BigDecimal(amount));
    }
}
