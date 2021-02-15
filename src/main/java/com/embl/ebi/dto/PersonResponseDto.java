package com.embl.ebi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDto extends PersonDto implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Integer personId;
}
