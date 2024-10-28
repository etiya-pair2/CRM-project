package com.etiya.customerservice.dto.city;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateCityRequest {
    @NotNull
    @NotBlank(message = "Lütfen Şehir İsmi Giriniz")
    @Size(min = 3, message = "Şehir ismi en az 3 harfli olmalıdır")
    private String name;
}
