package com.embl.ebi.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto implements Serializable {

    @JsonProperty("first_name")
    @NotNull(message = "First name is required")
    @NonNull()
    protected String firstName;

    @JsonProperty("last_name")
    @NotNull(message = "Last name is required")
    protected String lastName;

    @JsonProperty("age")
    @NotNull(message = "Age is required")
    protected Integer age;

    @JsonProperty("favourite_color")
    @NotNull(message = "Favourite color is required")
    protected String favouriteColor;
}
