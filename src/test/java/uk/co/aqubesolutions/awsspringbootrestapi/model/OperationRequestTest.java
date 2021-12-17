package uk.co.aqubesolutions.awsspringbootrestapi.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class OperationRequestTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    @DisplayName("Test First Number must be greater than or equal to one")
    void testFirstNumberGreaterThanOrEqualToOne() {
        OperationRequest request = new OperationRequest(0, 1);
        Set<ConstraintViolation<OperationRequest>> violations = validator.validate(request);
        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<OperationRequest> violation = violations.iterator().next();
        assertThat(violation.getPropertyPath().toString()).isEqualTo("firstNumber");
        assertThat(violation.getMessage()).isEqualTo("The minimum value for first number must be greater than or equal to 1");

        request = new OperationRequest(1, 1);
        violations = validator.validate(request);
        assertThat(violations.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Test Second Number must be positive greater than or equal to one")
    void testSecondNumberGreaterThanOrEqualToOne() {
        OperationRequest request = new OperationRequest(1, -1);
        Set<ConstraintViolation<OperationRequest>> violations = validator.validate(request);
        assertThat(violations.size()).isEqualTo(1);
        ConstraintViolation<OperationRequest> violation = violations.iterator().next();
        assertThat(violation.getPropertyPath().toString()).isEqualTo("secondNumber");
        assertThat(violation.getMessage()).isEqualTo("The number must be positive number greater than zero");

        request = new OperationRequest(1, 0);
        violations = validator.validate(request);
        assertThat(violations.size()).isEqualTo(1);
        violation = violations.iterator().next();
        assertThat(violation.getPropertyPath().toString()).isEqualTo("secondNumber");
        assertThat(violation.getMessage()).isEqualTo("The number must be positive number greater than zero");

        request = new OperationRequest(1, 1);
        violations = validator.validate(request);
        assertThat(violations.isEmpty()).isTrue();
    }
}