package uk.co.aqubesolutions.awsspringbootrestapi.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import uk.co.aqubesolutions.awsspringbootrestapi.model.Result;
import uk.co.aqubesolutions.awsspringbootrestapi.service.MathsService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class MathsOperationControllerTest {
    @Mock
    private MathsService service;

    @InjectMocks
    private MathsOperationController controller;

    @Captor
    private ArgumentCaptor<Integer> firstNumberArgumentCaptor;

    @Captor
    private ArgumentCaptor<Integer> secondNumberArgumentCaptor;

    private MultiValueMap<String, String> params;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        params = new LinkedMultiValueMap<>();
        params.add("firstNumber", "12");
        params.add("secondNumber", "4");
    }

    @Test
    @DisplayName("addOperation gives bad Operation with incorrect request parameter")
    void testAddOperationGivesBadRequestError() throws Exception {
        mockMvc.perform(get("/operations/add")
                .param("firstNumber", "0")
                .param("secondNumber", "0"))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    @DisplayName("addOperation gives correct result with correct request parameter")
    void testAddOperationGivesCorrectResult() throws Exception {
        Result result = new Result(8, "Addition of:5 and 3");
        when(service.addOperation(5, 3)).thenReturn(result);

        mockMvc.perform(get("/operations/add")
                .param("firstNumber", "5")
                .param("secondNumber", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is("8"), String.class))
                .andExpect(jsonPath("$.operationMessage", is("Addition of:5 and 3")))
                .andDo(print());

        verify(service).addOperation(firstNumberArgumentCaptor.capture(), secondNumberArgumentCaptor.capture());
        assertThat(firstNumberArgumentCaptor.getValue()).isEqualTo(5);
        assertThat(secondNumberArgumentCaptor.getValue()).isEqualTo(3);
    }

    @Test
    @DisplayName("subtractOperation gives correct result with correct request parameter")
    void testSubtractOperationGivesCorrectResult() throws Exception {
        Result result = new Result(8, "Subtraction of:12 and 4");
        when(service.subtractOperation(12, 4)).thenReturn(result);

        mockMvc.perform(get("/operations/subtract")
                .params(params))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is("8"), String.class))
                .andExpect(jsonPath("$.operationMessage", is("Subtraction of:12 and 4")))
                .andDo(print());

        verify(service).subtractOperation(firstNumberArgumentCaptor.capture(), secondNumberArgumentCaptor.capture());
        assertThat(firstNumberArgumentCaptor.getValue()).isEqualTo(12);
        assertThat(secondNumberArgumentCaptor.getValue()).isEqualTo(4);
    }

    @Test
    @DisplayName("multiplyOperation gives correct result with correct request parameter")
    void testMultiplyOperationGivesCorrectResult() throws Exception {
        Result result = new Result(48, "Multiplication of:12 and 4");
        when(service.multiplyOperation(12, 4)).thenReturn(result);

        mockMvc.perform(get("/operations/multiply")
                .params(params))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is("48"), String.class))
                .andExpect(jsonPath("$.operationMessage", is("Multiplication of:12 and 4")))
                .andDo(print());

        verify(service).multiplyOperation(firstNumberArgumentCaptor.capture(), secondNumberArgumentCaptor.capture());
        assertThat(firstNumberArgumentCaptor.getValue()).isEqualTo(12);
        assertThat(secondNumberArgumentCaptor.getValue()).isEqualTo(4);
    }

    @Test
    @DisplayName("divideOperation gives correct result with correct request parameter")
    void testDivideOperationGivesCorrectResult() throws Exception {
        Result result = new Result(3, "Division of:12 and 4");
        when(service.divideOperation(12, 4)).thenReturn(result);

        mockMvc.perform(get("/operations/divide")
                .params(params))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is("3"), String.class))
                .andExpect(jsonPath("$.operationMessage", is("Division of:12 and 4")))
                .andDo(print());

        verify(service).divideOperation(firstNumberArgumentCaptor.capture(), secondNumberArgumentCaptor.capture());
        assertThat(firstNumberArgumentCaptor.getValue()).isEqualTo(12);
        assertThat(secondNumberArgumentCaptor.getValue()).isEqualTo(4);
    }
}