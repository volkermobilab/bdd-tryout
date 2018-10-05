package com.mobilabsolutions.bdd.bddtryout;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.mobilabsolutions.bdd.bddtryout.account.Account;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions extends ApplicationIntegrationTest {

	@Given("^client has registered using (.+), (.+), (.+), (.+)$")
	public void clientHasRegisteredUsing(String firstName, String lastName, String username, String password)
			throws Throwable {
		this.executePost("/accounts", new Account(firstName, lastName, username, password), Void.class);
	}

	@When("^client requests single account (.+)$")
	public void clientRequestsAccountByName(String username) {
		this.executeGet("/accounts/" + username, Account.class);
	}

	@When("^client submits account data (.+), (.+), (.+), (.+)$")
	public void clientSubmitsUserData(String firstName, String lastName, String username, String password)
			throws Throwable {
		this.clientHasRegisteredUsing(firstName, lastName, username, password);
	}

	@When("^client calls /version$")
	public void clientCallsVersion() throws Throwable {
		executeGet("/version", String.class);
	}

	@Then("^client receives status code (\\d+)$")
	public void clientReceivesStatusCode(int statusCode) throws Throwable {
		assertThat("status code is incorrect : ", lastResponse.getStatusCode(), is(statusCode));
	}

	@And("^client receives server version (.+)$")
	public void clientReceivesServerVersionBody(String version) throws Throwable {
		assertThat(lastResponse.getResponseBody(), is(version));
	}

	@And("^client receives firstname (.+)$")
	public void clientReceivesFirstname(String firstname) throws Throwable {
		assertTrue(lastResponse.getResponseBody() instanceof Account);
		assertThat(((Account) lastResponse.getResponseBody()).getFirstName(), is(firstname));
	}

	@When("^client requests all accounts$")
	public void clientRequestsAllAccounts() {
		this.executeGet("/accounts", List.class);
	}

	@Then("^number of accounts is (\\d+)$")
	public void numberOfAccountsIs(int size) {
		assertThat(((List<Account>) lastResponse.getResponseBody()).size(), is(size));
	}

}
