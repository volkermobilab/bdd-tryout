Feature: Server Version can be retrieved 

Scenario: Client makes request to GET /version 
	When client calls /version 
	Then client receives status code 200 
	And client receives server version 1.0