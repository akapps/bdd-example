package ch.antaes.kapps.demo.bdd.glue;

import ch.antaes.kapps.demo.bdd.test.AbstractAccountManipulation;
import ch.antaes.kapps.demo.bdd.test.base.BusinessTestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Steps definition for "account_management.feature".
 * 
 * @author Antoine Kapps
 */
public class AccountCalculationSteps extends BusinessTestBase {

    @Autowired
    private AbstractAccountManipulation testLayer;


    @Given("^I have \\$(\\d+) on my account$")
    public void i_have_$_on_my_account(int initialValue) {
        testLayer.initializeAccountWith(initialValue);
    }

    @When("^I withdraw \\$(\\d+)$")
    public void i_withdraw_$(int value) {
        testLayer.withdraw(value);
    }

    @When("^I deposit \\$(\\d+)$")
    public void i_deposit_$(int value) {
        testLayer.deposit(value);
    }

    @Then("^my account balance should be \\$(\\d+)$")
    public void my_account_balance_should_be_$(int expectedValue) {
        assertThat(testLayer.getAccountBalance()).as("Account balance")
                .isEqualTo(expectedValue);
    }

    @Then("^the transaction is refused$")
    public void the_transaction_is_refused() {
        assertThat(testLayer.getExceptionThrownDuringOperation())
                .containsInstanceOf(IllegalStateException.class)
                .map(Exception::getMessage)
                .hasValueSatisfying(
                        msg -> assertThat(msg).as("Exception message").contains("Not enough money on the account")
                );
    }
    
}
