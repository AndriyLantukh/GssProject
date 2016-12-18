package ua.com.gosmartservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.gosmartservice.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}