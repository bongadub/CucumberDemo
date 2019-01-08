Feature:
  Verify different operations using Rest-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/posts"
    And I perform GET for the post number "2"
    Then I should see the author name as "Bonga"

  Scenario Outline: POST Operation
    Given I create a post method with author <name> and id <id> with title <title>
    Then Response code should be "201"
    Examples:
      | name          | id      | title        |
      | " User "      | " 4 "   | " Cucumber " |
      | " New User "  | " 1 "   | " Demo "     |



  Scenario Outline: Delete Operation
    Given I perform Delete operation for id <id>
    Then Response status code should be "200"
    Examples:
      | id    |
      | " 4 " |
      | " 1 " |

  Scenario: Update operation
    Given I create a update operation
