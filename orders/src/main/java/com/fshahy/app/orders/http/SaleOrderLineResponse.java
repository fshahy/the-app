package com.fshahy.app.orders.http;

import com.fshahy.app.orders.dto.SaleOrderLineDto;

public class SaleOrderLineResponse {
    
    public long id;
    public long product_id;
    public long order_id;
    public String created;

    public SaleOrderLineResponse(SaleOrderLineDto dto) {
        this.id = dto.getId();
        this.product_id = dto.getProduct().getId();
        this.order_id = dto.getSaleOrder().getId();
        this.created = dto.getCreated().toString();
    }

}
