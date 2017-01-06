package ua.com.gosmartservice.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.gosmartservice.model.Customer;
import ua.com.gosmartservice.model.OrderPoint;
import ua.com.gosmartservice.model.TheOrder;
import ua.com.gosmartservice.repository.CustomerRepository;
import ua.com.gosmartservice.repository.OrderPointRepository;
import ua.com.gosmartservice.repository.OrderRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    OrderPointRepository pointRepo;

    @Autowired
    CustomerRepository customerRepo;

    @RequestMapping("/orders")
    public List<TheOrder> getOrders() {
        List<TheOrder> orders = new ArrayList<>();
        orderRepo.findAll().forEach(order -> orders.add(order));
        return orders;
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
    public TheOrder addOrder(@PathVariable long id) {
        Customer customer = customerRepo.findOne(id);
        TheOrder newOrder = new TheOrder(customer);
        return orderRepo.save(newOrder);
    }

    @RequestMapping(value = "/order/addPoint", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
    public OrderPoint addPoint(@RequestBody PointReq p) {
        TheOrder theOrder = orderRepo.findOne(p.getOrderId());
        OrderPoint newPoint = new OrderPoint(p.getOrderId(), p.getServiceType(), p.getDeviceModel(), new BigDecimal(p.getPrice()), theOrder.getOrderStartDate());
        return pointRepo.save(newPoint);
    }

//    @RequestMapping(value = "/order/status/{orderStatus}")
//    public List<TheOrder> getOrdersByStatus(@PathVariable String orderStatus) {
//        return orderRepo.findOrdersByStatus(orderStatus);
//    }
}

@Data
class PointReq {
    private Long orderId;
    private String serviceType;
    private String deviceModel;
    private Integer price;
}


