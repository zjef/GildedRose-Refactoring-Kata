Feature: Kotlin

  Scenario Outline: Update items in the store
    Given I have "<name>" with a sellIn of <sellInBefore> and a quality of <qualityBefore>
    When I update the items in the store
    Then The item has a sellIn of <sellInAfter> and a quality of <qualityAfter>

    Examples:
      | name          | sellInBefore | qualityBefore | sellInAfter | qualityAfter |
      | standard item | 10           | 10            | 9           | 9            |

