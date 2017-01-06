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

    private Long orderId;

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
    private Date checkedDate;
    private Date inOperationDate;
    private Date readyDate;
    private Date shippedDate;
    private Date closedDate;


    public OrderPoint(Long orderId, String serviceType, String deviceModel, BigDecimal price, Date startDate) {
        this.orderId = orderId;
        this.serviceType = serviceType;
        this.deviceModel = deviceModel;
        this.price = price;
        this.startDate = startDate;
    }

}
