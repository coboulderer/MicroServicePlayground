package rk.playground;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGreetingControllerWithBasicSecurity() {
        String plainCreds = "guest:guest123";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + new String(Base64.encode(plainCreds.getBytes())));
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<Greet> response = restTemplate.exchange("/", HttpMethod.GET, request,
                Greet.class);

        Assert.assertEquals("Hello From Spring Boot!!", response.getBody().getMessage());
	}
}
