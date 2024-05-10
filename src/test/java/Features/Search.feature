Feature: User searches and checks for products in the site and may add them to cart or take a screenshot

	Background:
		Given User is on homepage

  Scenario: User searches products within a range and takes screenshot
    When User searches for a "<product>"
    Then User gets search results
    When User gives <min> and <max> range
    Then User takes screenshot of first "<product>"
    Examples:
    | product	|		 min		|		 max		|
    |	laptop	|		10000		|		50000		|
    | phone		|  	30000		|		80000		|
    |  dslr   |		25000   |		30000		|
    
    
    
  Scenario: User creates a cart for free delivery
  	
		When User searches for a "<product>"
  	Then User gets search results
  	When User gives <min> price
  	Then User adds first product to cart
  	And User clicks on Cart button
  	Then User takes screenshot of entire page for "<product>"
  	But Delivery is Free
  	Examples:
  	| product |    min    |
  	|		pen		|		 100		| #This fails because cart value is less than 499
  	|	 clock  |    499    |
  	|  watch  |    1000   | #This fails since amazon doesn't allow a direct "Add to cart" option for watches
  	