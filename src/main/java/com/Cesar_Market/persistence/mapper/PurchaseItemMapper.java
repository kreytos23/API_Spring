package com.Cesar_Market.persistence.mapper;

import com.Cesar_Market.domain.PurchaseItem;
import com.Cesar_Market.persistence.entity.ComprasProductos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target = "productID"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado",target = "state")
    })
    PurchaseItem toPurchaseItem (ComprasProductos comprasProductos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProductos toComprasProductos(PurchaseItem purchaseItem);

}
