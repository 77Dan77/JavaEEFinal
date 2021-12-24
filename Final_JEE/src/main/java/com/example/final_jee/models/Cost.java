package com.example.final_jee.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "costs")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "cost", nullable = false)
    private Double cost;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

//    @OneToOne
//    @JoinColumn(name = "good_id")
//    private com.example.final_jee.models.Goods good;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}