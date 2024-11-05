package com.etiya.customerservice;

import com.etiya.customerservice.dto.individualCustomer.*;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import com.etiya.customerservice.rules.IndCustBusinessRules;
import com.etiya.customerservice.service.concretes.IndividualCustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IndividualCustomerServiceImplTest {

    @InjectMocks
    private IndividualCustomerServiceImpl individualCustomerService;

    @Mock
    private IndividualCustomerRepository individualCustomerRepository;

    @Mock
    private IndCustBusinessRules indCustBusinessRules;

    @Mock
    private IndividualCustomerMapper indCustMapper;

    private UUID customerId;
    private IndividualCustomer individualCustomer;
    private CreateIndividualCustomerRequest createRequest;
    private CreateIndividualCustomerResponse createResponse;
    private UpdateIndividualCustomerRequest updateRequest;
    private UpdateIndividualCustomerResponse updateResponse;
    private DeleteIndividualCustomerResponse deleteResponse;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize mock data
        customerId = UUID.randomUUID();
        System.out.println(customerId);

        individualCustomer = new IndividualCustomer();
        individualCustomer.setId(customerId);
        individualCustomer.setNationalityId("12345678789");
        individualCustomer.setStatus(true);

        createRequest = new CreateIndividualCustomerRequest();
        createRequest.setNationalityId("12345678789");
        createResponse = new CreateIndividualCustomerResponse();

        updateRequest = new UpdateIndividualCustomerRequest();
        updateRequest.setCustomerId(customerId);
        updateRequest.setMotherName("");
        updateRequest.setFatherName("");
        updateRequest.setGender("");
        updateResponse = new UpdateIndividualCustomerResponse();

        deleteResponse = new DeleteIndividualCustomerResponse();
    }

    @Test
    void testCreate() {
        // Arrange
        when(indCustMapper.individualCustomerFromCreateRequest(createRequest)).thenReturn(individualCustomer);
        when(individualCustomerRepository.save(any(IndividualCustomer.class))).thenReturn(individualCustomer);
        when(indCustMapper.individualCustomerFromCreateResponse(individualCustomer)).thenReturn(createResponse);

        // Act
        CreateIndividualCustomerResponse response = individualCustomerService.create(createRequest);

        // Assert
        assertNotNull(response);
        verify(indCustBusinessRules).checkMernis(createRequest);
        verify(indCustBusinessRules).checkIndCustExist(createRequest.getNationalityId());
        verify(individualCustomerRepository).save(any(IndividualCustomer.class));
    }

/*    @Test
    public void testUpdateIndividualCustomer() {
        // Arrange
        when(indCustBusinessRules.checkCustomerExist(customerId)).thenReturn(individualCustomer);

        // Ensure the mapper correctly maps the incoming request to the IndividualCustomer object
        when(indCustMapper.individualCustomerFromUpdateRequest(updateRequest)).thenReturn(individualCustomer);
        when(indCustMapper.individualCustomerFromUpdateResponse(individualCustomer)).thenReturn(updateResponse);

        // Act
        UpdateIndividualCustomerResponse response = individualCustomerService.update(updateRequest);

        // Assert
        assertNotNull(response);

        // Check that the fields were updated correctly
        assertEquals(individualCustomer.getMotherName(), updateRequest.getMotherName());
        assertEquals(individualCustomer.getFatherName(), updateRequest.getFatherName());
        assertEquals(individualCustomer.getGender(), updateRequest.getGender());

        // Verify interactions with mocks
        verify(indCustBusinessRules).checkCustomerExist(customerId);
        verify(indCustMapper).individualCustomerFromUpdateRequest(updateRequest); // Ensure this method is called
        verify(individualCustomerRepository).save(individualCustomer); // Ensure save is called
        verify(indCustMapper).individualCustomerFromUpdateResponse(individualCustomer);
    }*/

    @Test
    void testDelete() {
        // Arrange
        when(indCustBusinessRules.checkCustomerExist(customerId)).thenReturn(individualCustomer);
        when(indCustMapper.individualCustomerFromDeleteResponse(individualCustomer)).thenReturn(deleteResponse);

        // Act
        DeleteIndividualCustomerResponse response = individualCustomerService.delete(customerId);

        // Assert
        assertNotNull(response);
        verify(indCustBusinessRules).checkCustomerExist(customerId);
        verify(individualCustomerRepository).save(individualCustomer);
        assertFalse(individualCustomer.getStatus());
        assertEquals("", individualCustomer.getNationalityId());
    }

    @Test
    void testGetAll() {
        // Arrange
        List<IndividualCustomer> customers = List.of(individualCustomer);
        List<GetAllIndividualCustomerResponse> responseList = List.of(new GetAllIndividualCustomerResponse());
        when(individualCustomerRepository.findAll()).thenReturn(customers);
        when(indCustMapper.individualCustomerFromGetAllResponse(any(IndividualCustomer.class))).thenReturn(responseList.get(0));

        // Act
        List<GetAllIndividualCustomerResponse> response = individualCustomerService.getAll();

        // Assert
        assertEquals(1, response.size());
        verify(individualCustomerRepository).findAll();
    }

    @Test
    void testGetById() {
        // Arrange
        GetByIdIndividualCustomerResponse expectedResponse = new GetByIdIndividualCustomerResponse();
        when(indCustBusinessRules.checkCustomerExist(customerId)).thenReturn(individualCustomer);
        when(indCustMapper.getIndividualCustomerById(individualCustomer)).thenReturn(expectedResponse);

        // Act
        GetByIdIndividualCustomerResponse response = individualCustomerService.getById(customerId);

        // Assert
        assertNotNull(response);
        verify(indCustBusinessRules).checkCustomerExist(customerId);
    }

    @Test
    void testSearchCustomer() {
        // Arrange
        SearchIndCustomerRequest request = new SearchIndCustomerRequest();
        List<IndividualCustomer> customers = List.of(individualCustomer);
        List<GetAllIndividualCustomerResponse> responseList = List.of(new GetAllIndividualCustomerResponse());
        when(individualCustomerRepository.searchIndividualCustomer(request)).thenReturn(customers);
        when(indCustMapper.individualCustomerFromGetAllResponse(any(IndividualCustomer.class))).thenReturn(responseList.get(0));

        // Act
        List<GetAllIndividualCustomerResponse> response = individualCustomerService.searchCustomer(request);

        // Assert
        assertEquals(1, response.size());
        verify(individualCustomerRepository).searchIndividualCustomer(request);
    }

    @Test
    void testFindById() {
        // Arrange
        Optional<IndividualCustomer> optionalCustomer = Optional.of(individualCustomer);
        GetByIdIndividualCustomerResponse expectedResponse = new GetByIdIndividualCustomerResponse();
        when(individualCustomerRepository.findById(customerId)).thenReturn(optionalCustomer);
        when(indCustMapper.getIndividualCustomerById(individualCustomer)).thenReturn(expectedResponse);

        // Act
        GetByIdIndividualCustomerResponse response = individualCustomerService.findById(customerId);

        // Assert
        assertNotNull(response);
        verify(individualCustomerRepository).findById(customerId);
    }
}
