package com.fshahy.app.orders.http;

import com.fshahy.app.orders.dto.SaleOrderDto;
import com.fshahy.app.orders.models.SaleOrder;
import jakarta.json.bind.annotation.JsonbProperty;

public class SaleOrderResponse {
    
    public long id;
    
    @JsonbProperty("customer_id")
    public long customerId;
    
    public String created;

    public SaleOrderResponse(SaleOrderDto dto) {
        this.id = dto.getId();
        this.customerId = dto.getCustomerId();
        this.created = dto.getCreated().toString();
    }

}
