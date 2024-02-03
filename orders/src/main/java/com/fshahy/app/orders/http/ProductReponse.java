package com.fshahy.app.orders.http;

import com.fshahy.app.orders.dto.ProductDto;

public class ProductReponse {

    public long id;
    public String name;
    
    public ProductReponse(ProductDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
    }

}
