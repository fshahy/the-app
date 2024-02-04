package com.fshahy.app.orders.http;

import com.fshahy.app.orders.dto.CustomerDto;
import com.fshahy.app.orders.models.Customer;

public class CustomerResponse {
    
    public long id;
    public String name;

    public CustomerResponse(CustomerDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
    }

}
