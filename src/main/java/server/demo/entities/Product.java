package server.demo.entities;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Double price;

}
