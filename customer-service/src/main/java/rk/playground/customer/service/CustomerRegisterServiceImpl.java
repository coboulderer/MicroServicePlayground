package rk.playground.customer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import rk.playground.customer.dao.CustomerDao;
import rk.playground.customer.domain.Customer;

/**
 * Implementation for CustomerRegisterService
 */
@Service
@Lazy
public class CustomerRegisterServiceImpl implements CustomerRegisterService{

    private CustomerDao customerDao;
    private Sender sender;

    @Autowired
    public CustomerRegisterServiceImpl(CustomerDao customerDao, Sender sender) {
        this.customerDao = customerDao;
        this.sender = sender;
    }

    public Customer register(Customer customer) {
        Optional<Customer> existingCustomer = customerDao.findByName(customer.getName());
        if (existingCustomer.isPresent()) {
            throw new RuntimeException("Customer with name " + customer.getName() + " already " +
                    "exists");
        } else {
            customerDao.save(customer);
            sender.send(customer.getEmail());
        }
        return customer;
    }
}
