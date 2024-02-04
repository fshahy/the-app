package com.fshahy.app.orders.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "sale_orders")
@NamedQueries({
    @NamedQuery(name = "SaleOrder.All", query = "SELECT so FROM SaleOrder so")
})
public class SaleOrder {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<SaleOrderLine> lines;

    @Temporal(TemporalType.DATE)
    private Date created;
    
    public SaleOrder() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customerId) {
        this.customer = customerId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<SaleOrderLine> getLines() {
        return lines;
    }

    public void setLines(List<SaleOrderLine> lines) {
        this.lines = lines;
    }
    
}
