package uk.co.aqubesolutions.awsspringbootrestapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uk.co.aqubesolutions.awsspringbootrestapi.model.Result;

import static org.assertj.core.api.Assertions.assertThat;

class MathsServiceTest {

    private MathsService service;

    @BeforeEach
    void setUp() {
        service = new MathsService();
    }

    @Test
    @DisplayName("Test Add operation")
    void testAddOperation() {
        Result actualResult1 = service.addOperation(1, 3);
        assertThat(actualResult1.getResult()).isEqualTo(4);
        assertThat(actualResult1.getOperationMessage()).isEqualTo("Addition of:1 and 3");
        Result actualResult2 = service.addOperation(2, 7);
        assertThat(actualResult2.getResult()).isEqualTo(9);
        assertThat(actualResult2.getOperationMessage()).isEqualTo("Addition of:2 and 7");
    }

    @Test
    @DisplayName("Test Subtract operation")
    void testSubtractOperation() {
        Result actualResult1 = service.subtractOperation(7, 2);
        assertThat(actualResult1.getResult()).isEqualTo(5);
        assertThat(actualResult1.getOperationMessage()).isEqualTo("Subtraction of:7 and 2");
        Result actualResult2 = service.subtractOperation(11, 3);
        assertThat(actualResult2.getResult()).isEqualTo(8);
        assertThat(actualResult2.getOperationMessage()).isEqualTo("Subtraction of:11 and 3");
    }

    @Test
    @DisplayName("Test Multiply operation")
    void testMultiplyOperation() {
        Result actualResult1 = service.multiplyOperation(7, 2);
        assertThat(actualResult1.getResult()).isEqualTo(14);
        assertThat(actualResult1.getOperationMessage()).isEqualTo("Multiplication of:7 and 2");
        Result actualResult2 = service.multiplyOperation(11, 3);
        assertThat(actualResult2.getResult()).isEqualTo(33);
        assertThat(actualResult2.getOperationMessage()).isEqualTo("Multiplication of:11 and 3");
    }

    @Test
    @DisplayName("Test Divide operation")
    void testDivisionOperation() {
        Result actualResult1 = service.divideOperation(8, 2);
        assertThat(actualResult1.getResult()).isEqualTo(4);
        assertThat(actualResult1.getOperationMessage()).isEqualTo("Division of:8 and 2");
        Result actualResult2 = service.divideOperation(15, 3);
        assertThat(actualResult2.getResult()).isEqualTo(5);
        assertThat(actualResult2.getOperationMessage()).isEqualTo("Division of:15 and 3");
    }
}