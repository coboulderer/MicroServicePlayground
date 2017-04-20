package rk.playground.customer.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import rk.playground.customer.domain.Customer;

/**
 * Provides CRUD for Customer Entity
 */
@RepositoryRestResource
public interface CustomerDao extends JpaRepository<Customer, Long> {

    Optional<Customer> findByName(@Param("name") String name);
}
