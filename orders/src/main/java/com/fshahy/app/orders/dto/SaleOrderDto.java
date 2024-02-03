package com.fshahy.app.orders.dto;

import java.time.LocalDate;

public class SaleOrderDto {

    private long id;
    private CustomerDto customer;
    private LocalDate created;

    public SaleOrderDto() {}

    public SaleOrderDto(long id) {
        this.id = id;
    }

    public SaleOrderDto(String id) {
        if(id != null && !id.trim().equals("")) {
            this.id = Long.parseLong(id);
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customerDto) {
        this.customer = customerDto;
    }

    public LocalDate getCreated() {
        return created;
    }
    
    public void setCreated(LocalDate created) {
        this.created = created;
    }
    
}
