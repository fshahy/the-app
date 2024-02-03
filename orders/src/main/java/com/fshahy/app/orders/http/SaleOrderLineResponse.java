package com.fshahy.app.orders.http;

import com.fshahy.app.orders.dto.SaleOrderLineDto;

public class SaleOrderLineResponse {
    
    public long id;
    public long product;
    public long order;
    public String created;

    public SaleOrderLineResponse(SaleOrderLineDto dto) {
        this.id = dto.getId();
        this.product = dto.getProduct().getId();
        this.order = dto.getSaleOrder().getId();
        this.created = dto.getCreated().toString();
    }

}
