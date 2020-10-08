Feature: Kotlin

  Scenario Outline: Update items in the store
    Given I have "<name>" with a sellIn of <sellInBefore> and a quality of <qualityBefore>
    When I update the items in the store
    Then The item has a sellIn of <sellInAfter> and a quality of <qualityAfter>

    Examples:
      | name                                      | sellInBefore | qualityBefore | sellInAfter | qualityAfter |

      | standard item                             | 10           | 10            | 9           | 9            |
      | standard item                             | 10           | 1             | 9           | 0            |
      | standard item                             | 10           | 0             | 9           | 0            |
      | standard item                             | -5           | 10            | -6          | 8            |
      | standard item                             | -5           | 1             | -6          | 0            |

      | Aged Brie                                 | 10           | 10            | 9           | 11           |
      | Aged Brie                                 | 10           | 50            | 9           | 50           |
      | Aged Brie                                 | -5           | 10            | -6          | 12           |
      | Aged Brie                                 | -5           | 49            | -6          | 50           |

      | Backstage passes to a TAFKAL80ETC concert | 20           | 10            | 19          | 11           |
      | Backstage passes to a TAFKAL80ETC concert | 10           | 10            | 9           | 12           |
      | Backstage passes to a TAFKAL80ETC concert | 9            | 10            | 8           | 12           |
      | Backstage passes to a TAFKAL80ETC concert | 6            | 10            | 5           | 12           |
      | Backstage passes to a TAFKAL80ETC concert | 5            | 10            | 4           | 13           |
      | Backstage passes to a TAFKAL80ETC concert | 4            | 10            | 3           | 13           |
      | Backstage passes to a TAFKAL80ETC concert | 1            | 10            | 0           | 13           |
      | Backstage passes to a TAFKAL80ETC concert | 0            | 10            | -1          | 0            |
      | Backstage passes to a TAFKAL80ETC concert | -1           | 0             | -2          | 0            |

      | Backstage passes to a TAFKAL80ETC concert | 20           | 50            | 19          | 50           |
      | Backstage passes to a TAFKAL80ETC concert | 10           | 49            | 9           | 50           |
      | Backstage passes to a TAFKAL80ETC concert | 10           | 48            | 9           | 50           |
      | Backstage passes to a TAFKAL80ETC concert | 5            | 50            | 4           | 50           |
      | Backstage passes to a TAFKAL80ETC concert | 5            | 49            | 4           | 50           |
      | Backstage passes to a TAFKAL80ETC concert | 5            | 48            | 4           | 50           |
      | Backstage passes to a TAFKAL80ETC concert | 5            | 47            | 4           | 50           |

      | Sulfuras, Hand of Ragnaros                | 10           | 80            | 10          | 80           |
      | Sulfuras, Hand of Ragnaros                | -5           | 80            | -5          | 80           |


