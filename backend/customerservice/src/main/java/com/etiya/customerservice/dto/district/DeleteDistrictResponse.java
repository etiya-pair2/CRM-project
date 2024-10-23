package com.etiya.customerservice.dto.district;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeleteDistrictResponse {
    private UUID id;
    private UUID cityId;
}
