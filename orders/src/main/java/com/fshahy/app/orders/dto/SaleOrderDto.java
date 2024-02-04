package com.fshahy.app.orders.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Date;

public class SaleOrderDto {
    
    private long id;
    
    @JsonbProperty("customer_id")
    private long customerId;
    
    private Date created;
    
    public SaleOrderDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
}
