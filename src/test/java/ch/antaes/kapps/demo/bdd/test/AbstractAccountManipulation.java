package ch.antaes.kapps.demo.bdd.test;

import java.util.Optional;

/**
 * Abstract test layer for account manipulation.
 *
 * @author Antoine Kapps
 */
public abstract class AbstractAccountManipulation {

    private Exception exception;

    public abstract void initializeAccountWith(int initialValue);

    public final void deposit(int value) {
        try {
            doDeposit(value);
        } catch (Exception e) {
            exception = e;
        }
    }

    protected abstract void doDeposit(int value);

    public final void withdraw(int value) {
        try {
            doWithdraw(value);
        } catch (Exception e) {
            exception = e;
        }
    }

    protected abstract void doWithdraw(int value);

    public abstract int getAccountBalance();

    public final Optional<Exception> getExceptionThrownDuringOperation() {
        return Optional.ofNullable(exception);
    }

}
