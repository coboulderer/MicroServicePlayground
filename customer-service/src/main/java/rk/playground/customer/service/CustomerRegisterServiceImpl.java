package rk.playground.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rk.playground.customer.dao.CustomerDao;
import rk.playground.customer.domain.Customer;

/**
 * Implementation for CustomerRegisterService
 */
@Service
public class CustomerRegisterServiceImpl implements CustomerRegisterService{

    CustomerDao customerDao;

    @Autowired
    public CustomerRegisterServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public Customer register(Customer customer) {
        Optional<Customer> existingCustomer = customerDao.findByName(customer.getName());
        if (existingCustomer.isPresent()) {
            throw new RuntimeException("Customer with name " + customer.getName() + " already " +
                    "exists");
        } else {
            customerDao.save(customer);
        }
        return customer;
    }
}
