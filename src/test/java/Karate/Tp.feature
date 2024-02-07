Feature:Hello Elham

  Background:
    * print 'debug baseUrl:', baseUrl
    Given url baseUrl

  @actuator
  Scenario: Elham Actuator
    Given path '/actuator'
    When method GET
    Then status 200
    And print response
    And match $._links.health.href contains "health"
    And match $._links.info.href contains "info"

  @actuator
  Scenario: Elham Health
    Given path '/actuator/health'
    When method GET
    Then status 200
    And print response
    And match $.status == 'UP'

  @actuator
    Scenario: Elham Info
      Given path '/actuator/info'
      When method GET
      Then status 200
      And print response
      And match $.build.name == 'TP_rest_service'
      And match $.build.version == '#notnull'

  @api
  Scenario: Hello
    Given path '/api/hello'
    When method GET
    Then status 200
    And match $.title contains "Hello world!"

  @api
  Scenario: Hello bad request
    Given path '/api/hello2'
    When method GET
    Then status 404

  Scenario Outline: Hello <user>
    Given path '/api/hello'
    And params { name: '<user>' }
    When method GET
    Then status 200
    And match $.title contains "Hello <user>!"

    Examples:
      | user    |
      | Agnès   |
      | Elham   |
      | Thierry |
      | Halim    |








