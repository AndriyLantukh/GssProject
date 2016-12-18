package ua.com.gosmartservice.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private TheOrder theOrder;

    private String serviceType;
    private String deviceModel;
    private BigDecimal price;

    private String pointStatus;
    private String comment;
    private BigDecimal gotCash;
    private BigDecimal gotCard;
    private BigDecimal rate;
    private String repairman;
    private String info;
    private Date startDate;
    private Date inOperation;
    private Date ready;
    private Date shipped;

    public OrderPoint(TheOrder theOrder, String serviceType, String deviceModel, BigDecimal price) {
        this.theOrder = theOrder;
        this.serviceType = serviceType;
        this.deviceModel = deviceModel;
        this.price = price;
        this.startDate = theOrder.getOrderStartDate();
    }

}
