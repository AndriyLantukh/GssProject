package ua.com.gosmartservice.repository;

import org.springframework.data.repository.CrudRepository;
import ua.com.gosmartservice.model.OrderPoint;

/**
 * Created by Андрей on 05.12.2016.
 */
public interface OrderPointRepository extends CrudRepository<OrderPoint, Long> {
}
