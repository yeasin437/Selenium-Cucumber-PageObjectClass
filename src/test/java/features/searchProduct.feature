Feature: Search and Place the order for Products

Scenario: Search Experience for the product search in both home and offer page

Given User is on GreenCart Landing page
When user searched  with Shortnamme "Tom" and extracted actual name of product
Then user searched for "Tom" shortname in offers page
And validate product name in offers page matches with Landing Page