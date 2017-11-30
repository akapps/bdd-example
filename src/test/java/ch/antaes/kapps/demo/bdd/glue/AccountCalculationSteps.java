package ch.antaes.kapps.demo.bdd.glue;

import ch.antaes.kapps.demo.bdd.domain.Account;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Steps definition for "account_management.feature".
 * 
 * @author Antoine Kapps
 */
public class AccountCalculationSteps {

    private final Account account = Fixtures.createEmptyTestAccount();
    private Exception exception;

    @Given("^I have \\$(\\d+) on my account$")
    public void i_have_$_on_my_account(int initialValue) {
        account.setBalance(initialValue);
    }

    @When("^I withdraw \\$(\\d+)$")
    public void i_withdraw_$(int value) {
        executeOrCatchException(() -> account.substract(value));
    }

    @When("^I deposit \\$(\\d+)$")
    public void i_deposit_$(int value) {
        executeOrCatchException(() -> account.add(value));
    }

    @Then("^my account balance should be \\$(\\d+)$")
    public void my_account_balance_should_be_$(int expectedValue) {
        assertThat(account.getBalance()).as("Account balance").isEqualTo(expectedValue);
    }

    @Then("^the transaction is refused$")
    public void the_transaction_is_refused() {
        assertThat(exception).isNotNull()
                .isOfAnyClassIn(IllegalStateException.class)
                .hasMessageContaining("Not enough money on the account");
    }


    private void executeOrCatchException(Operation operation) {
        try {
            operation.execute();
        } catch (Exception e) {
            exception = e;
        }
    }
    
}
