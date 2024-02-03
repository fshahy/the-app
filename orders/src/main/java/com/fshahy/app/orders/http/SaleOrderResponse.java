package com.fshahy.app.orders.http;

import com.fshahy.app.orders.dto.SaleOrderDto;

public class SaleOrderResponse {
    
    public long id;
    public long customer;
    public String created;

    public SaleOrderResponse(SaleOrderDto dto) {
        this.id = dto.getId();
        this.customer = dto.getCustomer().getId();
        this.created = dto.getCreated().toString();
    }

}
