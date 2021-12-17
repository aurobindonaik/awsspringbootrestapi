package uk.co.aqubesolutions.awsspringbootrestapi.service;

import org.springframework.stereotype.Service;
import uk.co.aqubesolutions.awsspringbootrestapi.model.Result;

@Service
public class MathsService {
    /**
     * This is Add operation which adds two given numbers.
     *
     * @param firstNumber - first number
     * @param secondNumber - second number
     * @return result - the result of the operation
     */
    public Result addOperation(int firstNumber, int secondNumber){
        return new Result(firstNumber + secondNumber,
                String.format("Addition of:%d and %d", firstNumber, secondNumber));
    }

    /**
     * This is Subtract operation which subtract two given numbers.
     *
     * @param firstNumber - first number
     * @param secondNumber - second number
     * @return result - the result of the operation
     */
    public Result subtractOperation(int firstNumber, int secondNumber){
        return new Result(firstNumber - secondNumber,
                String.format("Subtraction of:%d and %d", firstNumber, secondNumber));
    }

    /**
     * This is Subtract operation which multiply two given numbers.
     *
     * @param firstNumber - first number
     * @param secondNumber - second number
     * @return result - the result of the operation
     */
    public Result multiplyOperation(int firstNumber, int secondNumber){
        return new Result(firstNumber * secondNumber,
                String.format("Multiplication of:%d and %d", firstNumber, secondNumber));
    }

    /**
     * This is Subtract operation which divides two given numbers.
     *
     * @param firstNumber - first number
     * @param secondNumber - second number
     * @return result - the result of the operation
     */
    public Result divideOperation(int firstNumber, int secondNumber){
        return new Result(firstNumber / secondNumber,
                String.format("Division of:%d and %d", firstNumber, secondNumber));
    }
}
