package ua.com.gosmartservice.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.gosmartservice.model.Customer;
import ua.com.gosmartservice.model.TheOrder;
import ua.com.gosmartservice.repository.CustomerRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepo;

    @RequestMapping("/customers")
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepo.findAll().forEach(customer -> customers.add(customer));
        return customers;
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.POST, consumes = "application/json; charset=UTF-8")
    public Customer addCustomer(@RequestBody CustomerReq c) {
        Customer customer = Customer.builder()
                .customerName(c.getCustomerName())
                .cellNumber(c.getCellNumber())
                .city(c.getCity())
                .newPostOfficeNumber(c.getNewPostOfficeNumber())
                .balance(new BigDecimal(c.getStartBalance()))
                .additionalInfo(c.getAdditionalInfo())
                .build();
        return customerRepo.save(customer);
    }

    @RequestMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return customerRepo.findOne(id);
    }

    @RequestMapping(value = "/customer/delete/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerRepo.delete(id);
    }

    @RequestMapping(value = "/customer/orders/{id}")
    public List<TheOrder> getCustomerOrders(@PathVariable long id) {
        Customer customer = customerRepo.findOne(id);
        if (customer != null) {
            return customer.getOrders();
        }
        return null;
    }

}

@Data
class CustomerReq {
    private String customerName;
    private String cellNumber;
    private String city;
    private String newPostOfficeNumber;
    private Integer startBalance;
    private String additionalInfo;
}



