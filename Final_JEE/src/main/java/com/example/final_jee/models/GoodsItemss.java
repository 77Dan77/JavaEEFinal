package com.example.final_jee.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "goods_items")
@Entity
public class GoodsItemss {
    @EmbeddedId
    private GoodsItemId id;

    public GoodsItemId getId() {
        return id;
    }

    public void setId(GoodsItemId id) {
        this.id = id;
    }
}