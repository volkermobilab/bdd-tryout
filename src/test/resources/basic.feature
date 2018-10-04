Feature: Server Version can be retrieved
  Scenario: Client makes request to GET /version
    When the client calls /version
    Then the client receives status code of 200
    And the client receives server version 1.0