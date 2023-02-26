package nl.multicode.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @NotEmpty(message = "name may not be empty")
    private String name;
    @Pattern(regexp = "^([0-2][0-9]|(3)[0-1])(-)(((0)[0-9])|((1)[0-2]))(-)\\d{4}$",
            message = "date must be valid and have dd-mm-yyyy format")
    private String birthDate;
    @NotEmpty(message = "hairColor may not be empty")
    private String hairColor;
}
