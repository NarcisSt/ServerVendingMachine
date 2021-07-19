package server.demo.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "DATE")
    private Date date = new Date();
}
