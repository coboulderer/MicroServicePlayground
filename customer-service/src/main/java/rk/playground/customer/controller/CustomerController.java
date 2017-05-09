package rk.playground.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rk.playground.customer.domain.Customer;
import rk.playground.customer.service.CustomerRegisterService;

/**
 * REST Controller
 */
@RestController
public class CustomerController {

    private CustomerRegisterService customerRegisterService;

    @Autowired
    public CustomerController(CustomerRegisterService customerRegisterService) {
        this.customerRegisterService = customerRegisterService;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    Customer register(@RequestBody Customer customer) {
        return customerRegisterService.register(customer);
    }
}
