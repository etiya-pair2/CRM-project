package com.etiya.customerservice.dto.district;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetByIdDistrictResponse {
    private UUID cityId;
    private String name;
}
