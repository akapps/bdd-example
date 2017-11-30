package ch.antaes.kapps.demo.bdd.test.impl;

import ch.antaes.kapps.demo.bdd.domain.Account;
import ch.antaes.kapps.demo.bdd.glue.Fixtures;
import ch.antaes.kapps.demo.bdd.test.AbstractAccountManipulation;

/**
 * Implementation of {@link AbstractAccountManipulation} based on the core-business domain objects.
 *
 * @author Antoine Kapps
 */
public class BusinessAccountManipulation extends AbstractAccountManipulation {

    private final Account account = Fixtures.createEmptyTestAccount();

    @Override
    public void initializeAccountWith(int initialValue) {
        account.setBalance(initialValue);
    }

    @Override
    protected void doDeposit(int value) {
        account.add(value);
    }

    @Override
    protected void doWithdraw(int value) {
        account.substract(value);
    }

    @Override
    public int getAccountBalance() {
        return account.getBalance();
    }
}
