package rk.playground.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import rk.playground.customer.dao.CustomerDao;
import rk.playground.customer.domain.Customer;

@SpringBootApplication
public class CustomerServiceApplication {

	@Bean
	CommandLineRunner init(CustomerDao customerDao) {
	    return (evt) -> {
            customerDao.save(new Customer("Adam", "adam@boot.com"));
            customerDao.save(new Customer("John", "John@email.com"));
            customerDao.save(new Customer("Dave", "dave@boot.com"));
            customerDao.save(new Customer("Mary", "Mary@email.com"));
            customerDao.save(new Customer("Jane", "jane@boot.com"));
            customerDao.save(new Customer("Jenn", "Jenn@email.com"));
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
}
