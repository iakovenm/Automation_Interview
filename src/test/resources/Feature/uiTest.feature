Feature: Testing Search Form
  As a User
  I want to be able to have an automated testing framework available
  which covers different scenarios for the Search UI Form.
  So that I can make sure Search displays correct result when applying filters with/without match
  and clearing search using clear filter functionality.

  Scenario Outline: Test search without match

    When user inputs search"<SEARCH_INPUT>"
    And user clicks on search filter
    And user selects to filter search result by"<FILTER>"
    Then user asserts search table column "<ID>" has value"<SEARCH_OUTPUT>"
    And user asserts table resume to be"<RESUME>"

    Examples:
      | SEARCH_INPUT | FILTER | ID | SEARCH_OUTPUT | RESUME                   |
      | 1            | Id     | 1  | 1             | Showing 1 of 3 customers |
      | postimex     | Name   | 2  | Postimex      | Showing 1 of 3 customers |
      | carthage     | City   | 4  | Carthage      | Showing 1 of 3 customers |


  Scenario Outline: Test email search with match

    When user inputs search"<EMAIL>"
    And user checks match checkbox
    And user clicks on search filter
    And user selects to filter search result by"Email"
    Then user asserts search email to be "<EMAIL>"
    And user asserts table resume to be"Showing 1 of 3 customers"

    Examples:
      | EMAIL                |
      | office@alabaster.com |
      | conatact@postimex.pl |
      | info@bond.ir         |


  Scenario Outline: Test clear search filter
    Given user has filter and search applied"<SEARCH_INPUT>","<FILTER>"
    When user clicks on clearFilter
    Then user asserts search is empty
    And user asserts table resume to be"Showing 3 of 3 customers"

    Examples:
      | SEARCH_INPUT | FILTER |
      | 1            | Id     |
      | postimex     | Name   |
      | carthage     | City   |


  Scenario Outline: Test no filtered output

    Given user has filter and search applied"<SEARCH_INPUT>","<FILTER>"
    Then user asserts search table is empty
    And user asserts table resume to be"Showing 0 of 3 customers"
    Examples:
      | SEARCH_INPUT | FILTER |
      | 12           | Id     |
      | postimex3    | Name   |
      | carthage3    | City   |
