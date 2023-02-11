Feature: Login User feature

  @Tugas @PositiveCase
  Scenario: Post login with valid user json
    Given Login with valid user json
    When Send request post login user
    And Response body name should be token "QpwL5tke4Pnpja7X4"
    Then Should return status code 200
    And Validate json schema login user



      #Json file with without email
  @Tugas @NegativeCase
  Scenario: Post login with invalid user email json
    Given Login with invalid user email json
    When Send request post login user
    Then Should return status code 400

      #Json file with without password
  @Tugas @NegativeCase
  Scenario: Post login with invalid user password json
    Given Login with invalid user password json
    When Send request post login user
    And Response login body name should be error as "Missing password"
    Then Should return status code 400
    And Validate invalid login json schema

      #Json file with without email and password
  @Tugas @NegativeCase
  Scenario: Post login new user with invalid email and password json reqres API
    Given Post login user with invalid email and password json
    When Send request post login user
    Then Should return status code 400