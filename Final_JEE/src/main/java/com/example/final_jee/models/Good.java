package com.example.final_jee.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "goods", indexes = {
        @Index(name = "goods_name_key", columnList = "name", unique = true)
})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToOne(optional = false, mappedBy="good")
//    private Costs cost;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private com.example.final_jee.models.User user;
//
    @ManyToMany
    @JoinTable(name="goods_items",
            joinColumns = @JoinColumn(name="good_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="item_id", referencedColumnName="id")
    )
    private List<Item> items;
//


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}