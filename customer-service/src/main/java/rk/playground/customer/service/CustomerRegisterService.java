package rk.playground.customer.service;

import rk.playground.customer.domain.Customer;

/**
 * Contains business logic for registering customers
 */
public interface CustomerRegisterService {

    Customer register(Customer customer);
}
