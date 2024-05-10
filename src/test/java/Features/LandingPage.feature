Feature: User tests settings and options available on Landing Page

	Background: 
		Given User is on homepage
	
	Scenario: User checks for Delivery PinCodes
		When User enters <PinCode>
		Then User gets to know availability of delivery at their location
		Examples:
		| PinCode |
		| 208022  |
		| 101010  |
		| 121007  |
		| 110001  |
		
#	Scenario: User Screenshots steps to configure Amazon Gaming
#		When User navigates to Customer Service
#		And User selects Digital Services
#		When User clicks on Prime Gaming
#		And Clicks Get Started
#		Then User takes Screenshot of Setup Details