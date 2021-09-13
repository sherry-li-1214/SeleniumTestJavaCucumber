
Feature: Verify the loan calculator feature
  Background:
    Given Client navigate to the loan page

  @scenario1
  Scenario: Verify the borrow estimation and cleanup
    When they input the detailed information for themselves from test data file
    Then they click button Work out how much I can borrow
    Then they can get the estimate they could borrow
    When they click on Start Over button
    Then all the information has been cleared

  @scenario2
  Scenario: Negative test- Verify the invalid output
    And they enter below data for their information as below
      |living expenses|
      | 1             |
    Then they click button Work out how much I can borrow
    Then they see the error message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500."

