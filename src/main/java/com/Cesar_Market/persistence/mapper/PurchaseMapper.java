package com.Cesar_Market.persistence.mapper;

import com.Cesar_Market.domain.Purchase;
import com.Cesar_Market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "string", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra",target = "purchaseId"),
            @Mapping(source = "idCliente", target = ""),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioDePago", target = "paymentMethod"),
            @Mapping(source = "comprasProductosr", target = "items")
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente", ignore = true)
    })
    Compra toCompra (Purchase purchase);
}
