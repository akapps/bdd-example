package ch.antaes.kapps.demo.bdd.glue;

import ch.antaes.kapps.demo.bdd.domain.Account;
import ch.antaes.kapps.demo.bdd.domain.Customer;

/**
 * Des objets utilisables en test.
 *
 * @author Antoine Kapps
 */
public class Fixtures {

    private Fixtures() {
        throw new AssertionError("Not instantiable");
    }


    /**
     * Crée un nouvel objet Account pour un customer de test ("Antoine Test").
     *
     * @return un nouvel Account initialisé à 0.
     */
    public static Account createEmptyTestAccount() {
        Customer testCustomer = new Customer(0L, "Antoine Test");
        return new Account(testCustomer);
    }

}
