package com.example.hateoas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testDefaultGreetingController() {
		Greet greet = restTemplate.getForObject("/greeting", Greet.class);
		Assert.assertEquals("Hello HATEOAS", greet.getMessage());
	}

	@Test
	public void testGreetingControllerWithParam() {
		Greet greet = restTemplate.getForObject("/greeting?name=World!", Greet.class);
		Assert.assertEquals("Hello World!", greet.getMessage());
	}
}
