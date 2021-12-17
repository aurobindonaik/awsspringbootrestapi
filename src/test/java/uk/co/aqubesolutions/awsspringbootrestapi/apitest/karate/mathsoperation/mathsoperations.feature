Feature: Maths Operation Feature

  Background:
    * url baseUrl = 'http://localhost:8080'
    * def operationsBase = '/operations'
    
  Scenario: Test the Add operation
    Given path operationsBase + '/add'
    And params {firstNumber: 12, secondNumber: 4}
    When method GET
    Then status 200
    And assert response != null
    And match response.result == 16
    And match response.operationMessage == 'Addition of:12 and 4'

  Scenario: Test the Subtract operation
    Given path operationsBase + '/subtract'
    And params {firstNumber: 12, secondNumber: 4}
    When method GET
    Then status 200
    And assert response != null
    And match response.result == 8
    And match response.operationMessage == 'Subtraction of:12 and 4'

  Scenario: Test the Multiply operation
    Given path operationsBase + '/multiply'
    And params {firstNumber: 12, secondNumber: 4}
    When method GET
    Then status 200
    And assert response != null
    And match response.result == 48
    And match response.operationMessage == 'Multiplication of:12 and 4'

  Scenario: Test the Divide operation
    Given path operationsBase + '/divide'
    And params {firstNumber: 12, secondNumber: 4}
    When method GET
    Then status 200
    And assert response != null
    And match response.result == 3
    And match response.operationMessage == 'Division of:12 and 4'