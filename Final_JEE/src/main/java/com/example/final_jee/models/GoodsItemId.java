package com.example.final_jee.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GoodsItemId implements Serializable {
    private static final long serialVersionUID = -3956332491712253283L;
    @Column(name = "item_id", nullable = false)
    private Integer itemId;
    @Column(name = "good_id", nullable = false)
    private Integer goodId;

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, goodId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GoodsItemId entity = (GoodsItemId) o;
        return Objects.equals(this.itemId, entity.itemId) &&
                Objects.equals(this.goodId, entity.goodId);
    }
}