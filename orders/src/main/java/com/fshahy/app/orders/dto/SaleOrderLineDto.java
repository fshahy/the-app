package com.fshahy.app.orders.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Date;

public class SaleOrderLineDto {
    
    private long id;
    
    @JsonbProperty("product_id")
    private long productId;
    
    @JsonbProperty("order_id")
    private long orderId;
    
    private Date created;
    
    public SaleOrderLineDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    
}
