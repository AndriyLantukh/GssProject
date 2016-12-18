package ua.com.gosmartservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.com.gosmartservice.model.TheOrder;
import ua.com.gosmartservice.model.User;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<TheOrder, Long>{

}
