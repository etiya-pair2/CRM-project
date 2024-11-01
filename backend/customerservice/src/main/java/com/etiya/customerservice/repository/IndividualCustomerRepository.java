package com.etiya.customerservice.repository;

import com.etiya.customerservice.dto.individualCustomer.SearchIndCustomerRequest;
import com.etiya.customerservice.entity.IndividualCustomer;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, UUID>, JpaSpecificationExecutor<IndividualCustomer> {


    boolean existsByNationalityId(String nationalityId);

    Optional<IndividualCustomer> findByNationalityId(String nationalityId);


    //custom query method
    default List<IndividualCustomer> searchIndividualCustomer(SearchIndCustomerRequest request) {
        return findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            var contactMediumJoin = root.join("contactMediumList", JoinType.LEFT);
            var billingAccountJoin = root.join("billingAccountList", JoinType.LEFT);
            // Always filter for active status
            predicates.add(criteriaBuilder.isTrue(root.get("status")));
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nationalityId")), "%" + (request.getNatId() != null ? request.getNatId().toLowerCase() : "") + "%"));

            if (request.getCustomerId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("id"), request.getCustomerId()));
            }
            if (request.getAccNumber() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(billingAccountJoin.get("accountNumber")), "%" + request.getAccNumber().toLowerCase() + "%"));
            }
            if (request.getMobilePhone() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(contactMediumJoin.get("mobilePhone")), "%" + request.getMobilePhone().toLowerCase() + "%"));
            }
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%" + (request.getFirstName() != null ? request.getFirstName() : "") + "%"));
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%" + (request.getLastName() != null ? request.getLastName() : "") + "%"));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

    }
}