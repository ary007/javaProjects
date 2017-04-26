package com.boot;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebIntegrationTest
public class ShipWreckWebIntegrationTest {

	@Test
	public void ShipWreckWebIntegrationTest() throws IOException{
		RestTemplate rt=new RestTemplate();
		ResponseEntity<String> response=rt.getForEntity("http://localhost:8080/api/v1/shipwrecks",String.class);
		assertThat(response.getStatusCode(),equalTo(HttpStatus.OK));
		ObjectMapper ob=new ObjectMapper();
		JsonNode js=ob.readTree(response.getBody());
		assertThat(js.isMissingNode(),is(false));
		org.junit.Assert.assertNotEquals(js.toString(), "[]");
	}

}
