package com.fshahy.app.orders.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "sale_order_line")
// @NamedQueries({
//     @NamedQuery(name = "SaleOrderLine.OrderLines", query = "SELECT sol FROM SaleOrderLine sol WHERE order = ?1")
// })
public class SaleOrderLine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private SaleOrder order;

    @Temporal(TemporalType.DATE)
    private LocalDate created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productId) {
        this.product = productId;
    }

    public SaleOrder getOrderId() {
        return order;
    }

    public void setOrder(SaleOrder order) {
        this.order = order;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }
    
}
