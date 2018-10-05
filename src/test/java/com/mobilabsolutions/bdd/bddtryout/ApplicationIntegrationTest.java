package com.mobilabsolutions.bdd.bddtryout;

import java.io.IOException;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public class ApplicationIntegrationTest {

	protected RestTemplate restTemplate;
	protected ResponseResult<Object> lastResponse;

	public ApplicationIntegrationTest() {
		this.restTemplate = new RestTemplate();
		this.restTemplate.setErrorHandler(new SilentErrorHandler());
	}

	public class SilentErrorHandler extends DefaultResponseErrorHandler {
		@Override
		public void handleError(ClientHttpResponse response) throws IOException {
		}
	}

	protected <T> void executeGet(String url, Class<T> responseType) {
		ResponseEntity<T> response = restTemplate.getForEntity("http://localhost:8080" + url, responseType);
		this.lastResponse = new ResponseResult<>(response.getBody(), response.getStatusCodeValue());
	}

	protected <T> void executePost(String url, Object request, Class<T> responseType) {
		ResponseEntity<T> response = restTemplate.postForEntity("http://localhost:8080" + url, request, responseType);
		this.lastResponse = new ResponseResult<>(response.getBody(), response.getStatusCodeValue());
	}

	protected void executeDelete(String url) {
		restTemplate.delete("http://localhost:8080" + url);
	}

}
