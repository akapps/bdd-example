package ch.antaes.kapps.demo.bdd.domain;

import org.apache.commons.lang3.Validate;

/**
 * Représente le compte d'un client.
 *
 * @author Antoine Kapps
 */
public class Account {

    private final Customer owner;
    private int balance;

    public Account(Customer owner) {
        this.owner = owner;
    }

    public Customer getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void add(int amount) {
        Validate.isTrue(amount > 0, "Only positive amount can be added");
        balance += amount;
    }

    public void substract(int amount) {
        Validate.isTrue(amount > 0, "Only positive amount can be substracted");

        if (amount > balance) {
            throw new IllegalStateException("Not enough money on the account : " + amount + " > " + balance);
        }
        balance -= amount;
    }

}
