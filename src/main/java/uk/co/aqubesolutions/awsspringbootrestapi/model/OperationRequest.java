package uk.co.aqubesolutions.awsspringbootrestapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperationRequest {
    @Min(value = 1, message = "The minimum value for first number must be greater than or equal to 1")
    private int firstNumber;

    @Positive(message = "The number must be positive number greater than zero")
    private int secondNumber;
}
