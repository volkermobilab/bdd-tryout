Feature: Users Account Creation 
Scenario: Client registers a new account 
	Given client has registered using "John", "Doe", "john", "john123" 
	When client requests single account "john" 
	Then client receives status code 200 
	And client receives firstname "John" 
	
Scenario: Client registers again 
	Given client has registered using "John", "Doe", "john", "john123" 
	When client submits account data "John", "Doe", "john", "john123" 
	Then client receives status code 409 
	
Scenario: Client retrieves a not registered account 
	When client requests single account "unknown" 
	Then client receives status code 404 
	
Scenario: Multiple clients register accounts 
	Given client has registered using "John", "Doe", "john", "john123"
	And client has registered using "Jane", "Doe", "jane", "jane123"
	And client has registered using "Jim", "Doe", "jim", "jim123"
	When client requests all accounts
	Then client receives status code 200
	And number of accounts is 3
	