// package com.fshahy.app.orders.repositories;

// import java.util.List;
// import java.util.stream.Collectors;

// import org.modelmapper.ModelMapper;

// import com.fshahy.app.orders.dto.SaleOrderLineDto;
// import com.fshahy.app.orders.models.SaleOrderLine;

// import jakarta.enterprise.context.RequestScoped;
// import jakarta.inject.Inject;
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;

// @RequestScoped
// public class SaleOrderLineRepository {
    
//     @PersistenceContext(unitName = "the-app-pu")
//     private EntityManager entityManager;

//     @Inject
//     private ModelMapper modelMapper;

//     public SaleOrderLineDto save(SaleOrderLineDto saleOrderLineDto) {
//         SaleOrderLine saleOrderLine = this.modelMapper.map(saleOrderLineDto, SaleOrderLine.class);
//         entityManager.persist(saleOrderLine);
//         return this.modelMapper.map(saleOrderLine, SaleOrderLineDto.class);
//     }

//     public List<SaleOrderLineDto> getAll() {
//         return entityManager
//                 .createNamedQuery("SaleOrderLine.All", SaleOrderLine.class)
//                 .getResultStream()
//                 .map(sol -> this.modelMapper.map(sol, SaleOrderLineDto.class))
//                 .collect(Collectors.toList());
//     }

// }
