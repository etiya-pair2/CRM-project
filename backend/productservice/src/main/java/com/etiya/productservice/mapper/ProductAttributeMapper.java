package com.etiya.productservice.mapper;

import com.etiya.productservice.dto.attribute.*;
import com.etiya.productservice.dto.productAttribute.*;
import com.etiya.productservice.entity.Attribute;
import com.etiya.productservice.entity.ProductAttribute;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductAttributeMapper {

    ProductAttributeMapper INSTANCE = Mappers.getMapper(ProductAttributeMapper.class);

    @Mapping(source="productId", target = "product.id")
    @Mapping(source="attributeId", target = "attribute.id")
    ProductAttribute productAttributeFromCreateRequest(CreateProductAttributeRequest request);

    @Mapping(source="product.id", target = "productId")
    @Mapping(source="attribute.id", target = "attributeId")
    CreateProductAttributeResponse productAttributeFromCreateResponse (ProductAttribute productAttribute);

    @Mapping(source="productId", target = "product.id")
    @Mapping(source="attributeId", target = "attribute.id")
    ProductAttribute productAttributeFromUpdateRequest(UpdateProductAttributeRequest request);

    @Mapping(source="product.id", target = "productId")
    @Mapping(source="attribute.id", target = "attributeId")
    UpdateProductAttributeResponse productAttributeFromUpdateResponse(ProductAttribute productAttribute);

    @Mapping(source="product.id", target = "productId")
    @Mapping(source="attribute.id", target = "attributeId")
    List<GetAllProductAttributeResponse> productAttributeFromGetAllResponse(List<ProductAttribute> productAttributes);

    @Mapping(source="product.id", target = "productId")
    @Mapping(source="attribute.id", target = "attributeId")
    GetByIdProductAttributeResponse productAttributeFromGetByIdResponse(ProductAttribute productAttribute);

    DeleteProductAttributeResponse productAttributeFromDeleteResponse(ProductAttribute productAttribute);
}
