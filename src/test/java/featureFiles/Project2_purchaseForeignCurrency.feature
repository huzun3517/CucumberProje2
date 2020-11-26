Feature: Purchase Foreign Currency

  Background:
    Given Navigate to zero.webappsecurity
    When  Enter username and password and click Sign in button
    Then Click on the element in the Project content
      | payBills |

  Scenario Outline: Purchase Foreign Currency functionality

    And Click on the element in the Project content
      | purchaseForeignCurrency |

    Then User select "<currency>"

    Then User sends the keys in the Project content class
      | amount | <amount> |

    Then Click on the element in the Project content
      | <radioButton> |
      | puchaseBtn    |

    Then Success message should be displayed

    Examples:
      | currency | amount | radioButton      |
      | CAD      | 100    | selectedCurrency |
      | JPY      | 200    | usdRdBtn         |
      | EUR      | 300    | usdRdBtn         |