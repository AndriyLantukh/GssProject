package ua.com.gosmartservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TheOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private Date orderStartDate;
    private String orderStatus;

    @OneToMany(mappedBy = "theOrder", cascade = CascadeType.PERSIST)
    private List<OrderPoint> orderPoints;


    public TheOrder(Customer customer) {
        this.customer = customer;
        this.orderStartDate = new Date();
    }

}
