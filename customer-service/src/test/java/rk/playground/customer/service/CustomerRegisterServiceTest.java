package rk.playground.customer.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import rk.playground.customer.dao.CustomerDao;
import rk.playground.customer.domain.Customer;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

/**
 * Unit testing for CustomerRegisterService
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRegisterServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private CustomerRegisterService customerRegisterService;

    @MockBean
    private CustomerDao customerDao;

    private Customer customer;

    private Optional<Customer> customerOptional;

    @Before
    public void setup() {
        customer = new Customer("rick", "rick@email.com");
    }

    @Test
    public void testRegisterServiceCustomerIsAlreadyPresent() {
        customerOptional = Optional.of(customer);
        given(this.customerDao.findByName(any(String.class))).willReturn(customerOptional);
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Customer with name rick already exists");
        customerRegisterService.register(customer);
    }

    @Test
    public void testRegisterServiceSaveNewCustomer() {
        customerOptional = Optional.empty();
        given(this.customerDao.findByName(any(String.class))).willReturn(customerOptional);
        Customer customer = customerRegisterService.register(this.customer);
        Assert.assertEquals(customer.getName(), this.customer.getName());
        Assert.assertEquals(customer.getEmail(), this.customer.getEmail());
    }
}
