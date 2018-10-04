package com.mobilabsolutions.bdd.bddtryout;

import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs extends ApplicationIntegrationTest {

	@When("^the client calls /version$")
	public void theClientIssuesGETVersion() throws Throwable {
		executeGet("http://localhost:8080/version");
	}

	@Then("^the client receives status code of (\\d+)$")
	public void theClientReceivesStatusCodeOf(int statusCode) throws Throwable {
		final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
		assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
	}

	@And("^the client receives server version (.+)$")
	public void theClientReceivesServerVersionBody(String version) throws Throwable {
		assertThat(latestResponse.getBody(), is(version));
	}

}
