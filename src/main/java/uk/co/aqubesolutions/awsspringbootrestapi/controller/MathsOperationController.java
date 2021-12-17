package uk.co.aqubesolutions.awsspringbootrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.aqubesolutions.awsspringbootrestapi.model.OperationRequest;
import uk.co.aqubesolutions.awsspringbootrestapi.model.Result;
import uk.co.aqubesolutions.awsspringbootrestapi.service.MathsService;

import javax.validation.Valid;

@RestController
@RequestMapping("/operations")
public class MathsOperationController {
    private final MathsService mathsService;

    public MathsOperationController(MathsService mathsService) {
        this.mathsService = mathsService;
    }

    @GetMapping(path = "/add")
    public Result addOperation(@Valid OperationRequest request) {
        return mathsService.addOperation(request.getFirstNumber(), request.getSecondNumber());
    }

    @GetMapping(path = "/subtract")
    public Result subtractOperation(@Valid OperationRequest request) {
        return mathsService.subtractOperation(request.getFirstNumber(), request.getSecondNumber());
    }

    @GetMapping(path = "/multiply")
    public Result multiplyOperation(@Valid OperationRequest request) {
        return mathsService.multiplyOperation(request.getFirstNumber(), request.getSecondNumber());
    }

    @GetMapping(path = "/divide")
    public Result divideOperation(@Valid OperationRequest request) {
        return mathsService.divideOperation(request.getFirstNumber(), request.getSecondNumber());
    }

}
