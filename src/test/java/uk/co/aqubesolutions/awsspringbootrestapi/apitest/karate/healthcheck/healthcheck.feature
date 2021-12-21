Feature: Maths Operation Feature

  Background:
    * url baseUrl = 'http://localhost:8080'
    * def healthzBase = '/healthz'
    
  Scenario: Test the Add operation
    Given path healthzBase
    When method GET
    Then status 200
    And match response == '{healthz:"OK"}'
