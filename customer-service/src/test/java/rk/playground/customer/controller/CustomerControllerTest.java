package rk.playground.customer.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import rk.playground.customer.domain.Customer;
import rk.playground.customer.service.CustomerRegisterService;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

/**
 * Unit Testing for CustomerController
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CustomerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private CustomerRegisterService customerRegisterService;

    private Customer customer;

    @Before
    public void setup() {
        customer = new Customer("rick", "rick@email.com");
    }

    @Test
    public void testRegisterEndpoint() {
        given(customerRegisterService.register(any(Customer.class))).willReturn(customer);
        Customer customer = restTemplate.postForObject("/register", this.customer, Customer.class);
        Assert.assertEquals(customer.getName(), this.customer.getName());
        Assert.assertEquals(customer.getEmail(), this.customer.getEmail());
    }
}
