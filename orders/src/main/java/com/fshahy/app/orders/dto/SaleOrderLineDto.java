package com.fshahy.app.orders.dto;

import java.time.LocalDate;

public class SaleOrderLineDto {

    private long id;
    private ProductDto product;
    private SaleOrderDto saleOrder;
    private LocalDate created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public SaleOrderDto getSaleOrder() {
        return saleOrder;
    }

    public void setSaleOrder(SaleOrderDto saleOrder) {
        this.saleOrder = saleOrder;
    }

    public LocalDate getCreated() {
        return created;
    }
    
    public void setCreated(LocalDate created) {
        this.created = created;
    }

}
