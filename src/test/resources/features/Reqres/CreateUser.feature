Feature: Testing Create user Reqres API

  @Latihan @PositiveCase
  Scenario: Post create new user with valid json reqres API
    Given Post create user with valid json
    When Send request post create user
    Then Should return status code 201
    And Response body name should be "Taufik HM" and job "QA Engineer"
    And validate json schema create user



  @Tugas @NegativeCase
  Scenario: Post create new user with invalid string json and reqres API
    Given Post create user with invalid string json
    When Send request post create user
    Then Should return status code 400

  @Tugas @NegativeCase
  Scenario: Post create new user with invalid job json and reqres API
    Given Post create user without job json
    When Send request post create user
    Then Should return status code 400

  @Tugas @NegativeCase
  Scenario: Post create new user with invalid name json and reqres API
    Given Post create user with invalid name json
    When Send request post create user
    Then Should return status code 400




