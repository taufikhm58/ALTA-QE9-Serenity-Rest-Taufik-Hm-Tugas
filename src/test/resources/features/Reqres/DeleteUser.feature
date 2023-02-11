Feature: Delete User feature

  @Tugas @PositiveCase
  Scenario Outline: Delete users with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return status code 204
    Examples:
      | id |
      | 1  |
      | 2  |

 

  @Tugas @NegativeCase
  Scenario Outline: Delete users with invalid id
    Given Delete user with invalid id <id>
    When Send request delete user
    Then Should return status code 404
    Examples:
      | id                |
      | 90909090909090909 |
      | OMAGAAAAAAAAA     |
      | 0                 |


