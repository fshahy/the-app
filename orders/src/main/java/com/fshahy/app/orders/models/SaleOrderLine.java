package com.fshahy.app.orders.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

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
    private Date created;
    
    public SaleOrderLine() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public SaleOrder getOrder() {
        return order;
    }

    public void setOrder(SaleOrder order) {
        this.order = order;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    
}
