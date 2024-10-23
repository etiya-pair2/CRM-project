package com.etiya.customerservice.dto.city;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteCityResponse {
    private UUID id;
    private String name;
}
