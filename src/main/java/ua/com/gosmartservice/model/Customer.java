package ua.com.gosmartservice.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String cellNumber;
    private String city;
    private String newPostOfficeNumber;
    private BigDecimal balance;
    private String additionalInfo;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST)
    private List<TheOrder> orders;

}
