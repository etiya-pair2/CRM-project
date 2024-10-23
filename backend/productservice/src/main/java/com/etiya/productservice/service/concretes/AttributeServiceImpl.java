package com.etiya.productservice.service.concretes;

import com.etiya.productservice.dto.attribute.*;
import com.etiya.productservice.entity.Attribute;
import com.etiya.productservice.entity.Category;
import com.etiya.productservice.mapper.AttributeMapper;
import com.etiya.productservice.repository.AttributeRepository;
import com.etiya.productservice.service.abstracts.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository  attributeRepository;

    AttributeMapper attributeMapper = AttributeMapper.INSTANCE;
    @Override
    public List<GetAllAttributeResponse> getAll() {
        return attributeMapper.attributeFromGetAllResponse(attributeRepository.findAll());
    }

    @Override
    public GetByIdAttributeResponse getById(UUID id) {
        Optional<Attribute> attribute = attributeRepository.findById(id);
        return attribute.map(value -> attributeMapper.attributeFromGetByIdResponse(value)).orElse(null);
    }


    @Override
    public CreateAttributeResponse create(CreateAttributeRequest request) {
        Attribute attribute = attributeRepository.save(attributeMapper.attributeFromCreateRequest(request));
        return attributeMapper.attributeFromCreateResponse(attribute);

        //return attributeMapper.attributeFromCreateResponse(attributeRepository.save(attributeMapper.attributeFromCreateRequest(request)));
    }

    @Override
    public UpdateAttributeResponse update(UpdateAttributeRequest request) {
        Attribute attribute = attributeRepository.save(attributeMapper.attributeFromUpdateRequest(request));
        return attributeMapper.attributeFromUpdateResponse(attribute);
    }

    @Override
    public DeleteAttributeResponse delete(UUID id) {
        Optional<Attribute> attribute = attributeRepository.findById(id);
        attribute.ifPresent(attributeRepository::delete);
        return attributeMapper.attributeFromDeleteResponse(attribute.get());
    }
}
