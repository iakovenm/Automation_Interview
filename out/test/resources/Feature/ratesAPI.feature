#Feature: Testing Rates API
#  As a User
#  I want to be able to have an automated testing framework available which covers different
#  scenarios for the Rates API
#  So that I can make sure that the API’s are fit for purpose in the use of the exchange rate for financial
#  reasons
#
#  Scenario Outline: Rates API availability
#
#    When user calls "<API>"
#    Then server return response with a status "<STATUS>"
#
#    Examples:
#      | API                             | STATUS |
#      | latest                          | 200    |
#      | 2010-01-12                      | 200    |
#      |                                 | 400    |
#      | thelatest?sss                   | 400    |
#      | latest?sss                      | 400    |
#      | 0010-01-12                      | 400    |
#      | 2025-01-11                      | 400    |
#      | 23-02-2011                      | 400    |
#      | latest?base=USD&symbols=TTT     | 400    |
#      | latest?base=TTT                 | 400    |
#      | latest?base=USD&seee            | 400    |
#      | 2010-01-12?base=USD&symbols=YYY | 400    |
#      | 2010-01-12?base=YYY             | 400    |
#
#
#  Scenario Outline: Rates API positive response validation
#    When user calls "<API>"
#    Then server return response with correct "<BASE>", "<RATES>"
#
#
#    Examples:
#      | API                             | BASE | RATES   |
#      | latest                          | EUR  | GBP,HKD |
#      | latest?symbols=USD,GBP          | EUR  | USD,GBP |
#      | latest?base=USD                 | USD  | USD,GBP |
#      | latest?base=USD&symbols=GBP     | USD  | GBP     |
#      | 2010-01-12                      | EUR  | GBP,HKD |
#      | 2010-01-12?symbols=USD,GBP      | EUR  | USD,GBP |
#      | 2010-01-12?base=USD             | USD  | GBP,HKD |
#      | 2010-01-12?base=USD&symbols=GBP | USD  | GBP     |
#
#
#  Scenario Outline: Rates API positive date response validation
#    When user calls "<API>"
#    Then server return response with correct date "<DATE>"
#    Examples:
#      | API                             | DATE       |
#      | 2010-01-12                      | 2010-01-12 |
#      | 2010-01-12?symbols=USD,GBP      | 2010-01-12 |
#      | 2010-01-12?base=USD             | 2010-01-12 |
#      | 2010-01-12?base=USD&symbols=GBP | 2010-01-12 |
#
#  Scenario Outline: Rates API fields validation
#    When user calls "<API>"
#    Then server return response that includes fields "<BASE>", "<RATES>","<DATE>"
#
#    Examples:
#      | API                             | BASE | RATES | DATE |
#      | latest                          | base | rates | date |
#      | latest?symbols=USD,GBP          | base | rates | date |
#      | latest?base=USD                 | base | rates | date |
#      | latest?base=USD&symbols=GBP     | base | rates | date |
#      | 2010-01-12                      | base | rates | date |
#      | 2010-01-12?symbols=USD,GBP      | base | rates | date |
#      | 2010-01-12?base=USD             | base | rates | date |
#      | 2010-01-12?base=USD&symbols=GBP | base | rates | date |