package com.etiya.productservice.mapper;

import com.etiya.productservice.dto.attribute.*;
import com.etiya.productservice.dto.category.*;
import com.etiya.productservice.entity.Attribute;
import com.etiya.productservice.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AttributeMapper {

    AttributeMapper INSTANCE = Mappers.getMapper(AttributeMapper.class);

    Attribute attributeFromCreateRequest(CreateAttributeRequest dto);

    CreateAttributeResponse attributeFromCreateResponse (Attribute attribute);

    Attribute attributeFromUpdateRequest(UpdateAttributeRequest request);

    UpdateAttributeResponse attributeFromUpdateResponse(Attribute attribute);

    List<GetAllAttributeResponse> attributeFromGetAllResponse(List<Attribute> attributes);

//    @Mapping(source = "name", target = "name")
    GetByIdAttributeResponse attributeFromGetByIdResponse(Attribute attribute);

    DeleteAttributeResponse attributeFromDeleteResponse(Attribute attribute);
}
