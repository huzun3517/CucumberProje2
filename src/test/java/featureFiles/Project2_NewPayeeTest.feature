Feature: Test New Payee functionality

  Background:
    Given Navigate to zero.webappsecurity
    When  Enter username and password and click Sign in button
    Then Click on the element in the Project content
      | payBills |

  Scenario Outline: Test New Payee functionality

    And Click on the element in the Project content
      | addNewPayee |

    Then User sends the keys in the Project content class
      | payeeName    | <name>      |
      | payeeAddress | <address>   |
      | account      | <accountNo> |
      | payeeDetails | <details>   |

    Then Click on the element in the Project content
      | addBtn |

    Then Success message should be displayed "<name>"

    Examples:
      | name   | address | accountNo | details      |
      | Ali    | Turkiye | TR12345   | payeeDetails |
      | Ahmet  |         | TR12345   | payeeDetails |
      | Mehmet | Turkiye |           | payeeDetails |
      |        | Turkiye | TR12345   | payeeDetails |
      | Ayse   | Turkiye | TR12345   |              |