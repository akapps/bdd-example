package ch.antaes.kapps.demo.bdd.glue;

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

    private int account = 0;
    private Exception exception = null;

    @Given("^I have \\$(\\d+) on my account$")
    public void i_have_$_on_my_account(int initialValue) {
        account = initialValue;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void i_withdraw_$(int value) {
        if (value <= account) {
            account = account - value;
        }
        else {
            exception = new IllegalStateException("Not enough money on the account : " + value + " > " + account);
        }
    }

    @When("^I deposit \\$(\\d+)$")
    public void i_deposit_$(int value) {
        account = account + value;
    }

    @Then("^my account balance should be \\$(\\d+)$")
    public void my_account_balance_should_be_$(int expectedValue) {
        assertThat(account).as("Account balance").isEqualTo(expectedValue);
    }

    @Then("^the transaction is refused$")
    public void the_transaction_is_refused() {
        assertThat(exception).isNotNull()
                .isOfAnyClassIn(IllegalStateException.class)
                .hasMessageContaining("Not enough money on the account");
    }
    
}
