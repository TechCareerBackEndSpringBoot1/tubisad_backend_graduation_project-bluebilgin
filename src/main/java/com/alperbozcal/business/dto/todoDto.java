package com.alperbozcal.business.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class todoDto {
    private long todo_id;

    @NotEmpty(message = "ToDo adini eklemediniz...")
    private String todoName;


}
