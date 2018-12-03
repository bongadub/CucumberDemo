Feature:
  Verify different GET operations using Rest-assured

  Scenario: Verify one author of the post
    Given I perform GET operation for "/post"
    And I perform GET for the post number "2"
    Then I should see the author name as "Bonga"

  Scenario: Verify Post operation
    Given I perform POST operation for "/posts"