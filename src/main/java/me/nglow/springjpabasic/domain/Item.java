package me.nglow.springjpabasic.domain;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}
