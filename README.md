# Assignment 4 - REST API Test

Assignment 1 (Unit test / Mock): [Link](https://datsoftlyngby.github.io/soft2020spring/resources/85f09312-01-assignment-mocking.pdf)

Assignment 1 Solution: [Link](https://github.com/PBA-2sem/asgmt1_mocking_tdd) 

Assignment 2 (Integration test): [Link](https://datsoftlyngby.github.io/soft2020spring/resources/2b1e95b8-02-assignment-integration.pdf)

Assignment 2 Solution: [Link](https://github.com/PBA-2sem/asgmt1_mocking_tdd/tree/integration-test)

Assignment 3 (Database test): [Link](https://datsoftlyngby.github.io/soft2020spring/resources/db4fc3df-03-assignment-database.pdf)

Assignment 3 Solution: [Link](https://github.com/PBA-2sem/asgmt1_mocking_tdd/tree/database-test)

Assignment 4 (REST API Test): [Link](https://datsoftlyngby.github.io/soft2020spring/resources/5988f3c5-04-assignment-rest.pdf)

Assignment 4 Solution: [Link](https://github.com/PBA-2sem/asgmt1_mocking_tdd/tree/frontend-testing)

## Description

This branch of the repository contains the solution to **Assignment 4 - REST API Test** [Link](https://datsoftlyngby.github.io/soft2020spring/resources/5988f3c5-04-assignment-rest.pdf).

## REST API Test Execution

From your terminal of choice, navigate to the "banking" folder.

### Run all project tests:

```
mvn verify -Pwith_integration_test
```

### Run tests excluding intergration tests:

```
mvn verify
```

---

During the test phase, the instructions specified in [ApiResourceTest.java](https://github.com/PBA-2sem/asgmt1_mocking_tdd/blob/frontend-testing/banking/src/test/java/api/ApiResourceTest.java) are executed.

First, the database connection is established & data is inserted into the database from various sql scripts.

Afterwards, the tests specified in ApiResourceTest.java are run in sequence. 

The test methods make use of an instance of the [ApiResource.java](https://github.com/PBA-2sem/asgmt1_mocking_tdd/blob/frontend-testing/banking/src/main/java/api/ApiResource.java) where all the REST endpoints are specified. The API as a whole acts as a facade/wrapper around the various [Managers](https://github.com/PBA-2sem/asgmt1_mocking_tdd/tree/frontend-testing/banking/src/main/java/implementations/db) already implemented.

Finally, the database connection is closed.

## REST API Endpoints Overview

Rest API Endpoints corresponding with Banking Contract [methods](https://github.com/PBA-2sem/asgmt1_mocking_tdd/tree/frontend-testing/banking-contract/src/main/java/com/teamwingitt/banking/contract):

Running the Banking project locally, The root REST API URL is: [http://localhost:8080/banking](http://localhost:8080/banking) (port may vary). 

After the root URl, the following URIs exist:

| Type 	| URI (with query example)                                            	| Banking Contract Method 	|
|------	|----------------------------------------------------------	|---------------------------------------	|
| GET  	| /api/customer?id=1                                       	| getCustomer                           	|
| GET  	| /api/customer/accounts?id=1                              	| getAccounts                           	|
| GET  	| /api/bank?id=1                                           	| getBank                               	|
| GET  	| /api/bank/accounts?id=1                                  	| getAccounts                           	|
| GET  	| /api/account?id=1                                        	| getAccount                            	|
| GET  	| /api/account/balance?id=1                                	| getBalance                            	|
| GET  	| /api/account/withdrawals?id=1                            	| getWithdrawals                        	|
| GET  	| /api/account/deposits?id=1                               	| getDeposits                           	|
| POST 	| /api/account/transfer/id?amount=40&source=2&target=1     	| transfer [by account identifier]      	|
| POST 	| /api/account/transfer/number?amount=40&source=1&target=2 	| transfer [by accountnumber]           	|
| POST 	| /api/account/deposit?amount=69&id=1                      	| deposit                               	|
| POST 	| /api/account/withdraw?amount=69&id=1                     	| withdraw                              	|

## Test results

 ![REST API Test Results](<assets/api_test_results.PNG>)
 
## Author Details

**Group: Team Wing It**
- *Alexander Winther Hørsted-Andersen* (cph-ah353@cphbusiness.dk)
- *Andreas Due Jørgensen* (cph-aj285@cphbusiness.dk)
- *Mathias Bigler* (cph-mb493@cphbusiness.dk)
- *Stanislav Novitski* (cph-sn183@cphbusiness.dk)
