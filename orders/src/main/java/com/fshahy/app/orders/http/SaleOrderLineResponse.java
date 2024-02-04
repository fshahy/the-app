package com.fshahy.app.orders.http;

import com.fshahy.app.orders.dto.SaleOrderLineDto;
import jakarta.json.bind.annotation.JsonbProperty;

public class SaleOrderLineResponse {
    
    public long id;
    
    @JsonbProperty("product_id")
    public long productId;
    
    @JsonbProperty("order_id")
    public long orderId;
    
    public String created;

    public SaleOrderLineResponse(SaleOrderLineDto dto) {
        this.id = dto.getId();
        this.productId = dto.getProductId();
        this.orderId = dto.getOrderId();
        this.created = dto.getCreated().toString();
    }

}
