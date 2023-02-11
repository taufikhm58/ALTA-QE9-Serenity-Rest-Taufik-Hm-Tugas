Feature: Register User feature reqres API

      #Json file with email : eve.holt@reqres.i
  @Tugas @PositiveCase
  Scenario: Post register new user with valid json reqres API
    Given Post register user with valid json
    When Send request post register user
    Then Should return status code 200
    And Response body id should be 4 and token "QpwL5tke4Pnpja7X4"
    And Validate json schema register


  @Tugas @PositiveCase
  Scenario: Post register new user with valid json another email reqres API
    Given Post register user with valid json another email
    When Send request post register user
    Then Should return status code 200
    And Response body id should be 4 and token "QpwL5tke4Pnpja7X4"
    And Validate json schema register



      #Json file with without password
  @Tugas @NegativeCase
  Scenario: Post register new user with invalid password json reqres API
    Given Post register user with invalid password json
    When Send request post register user
    Then Should return status code 400
    And Response body name should be error as "Missing password"
    And Validate invalid register json schema

      #Json file with without email
  @Tugas @NegativeCase
  Scenario: Post register new user with invalid email json reqres API
    Given Post register user with invalid email json
    When Send request post register user
    Then Should return status code 400

    #Json file with without email and password
  @Tugas @NegativeCase
  Scenario: Post register new user with invalid email and password json reqres API
    Given Post register user with invalid email and password json
    When Send request post register user
    Then Should return status code 400




