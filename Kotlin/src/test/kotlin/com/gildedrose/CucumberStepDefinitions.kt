package com.gildedrose

import io.cucumber.java8.En
import org.junit.jupiter.api.Assertions

class CucumberStepDefinitions : En {

    init {
        val items = emptyList<Item>().toMutableList()

        var updatedItems = emptyArray<Item>()
        val item = Given("I have {string} with a sellIn of {int} and a quality of {int}") { name: String, sellInBefore: Int, qualityBefore: Int ->
            run {
                items.add(Item(name, sellInBefore, qualityBefore))
            }
        }

        When("I update the items in the store") {
            val store = GildedRose(items.toTypedArray())
            store.updateQuality()
            updatedItems = store.items
        }

        Then("The item has a sellIn of {int} and a quality of {int}") {
            sellInAfter: Int, qualityAfter: Int ->
            run {
                Assertions.assertEquals(qualityAfter, updatedItems[0].quality)
                Assertions.assertEquals(sellInAfter, updatedItems[0].sellIn)
            }
        }
    }

}