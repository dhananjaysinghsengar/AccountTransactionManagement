# Getting Started

### Project build
./gradle clean build

### Application run
./gradle bootRun

### Rest API for account transaction management
Api supports two methods
* Use http://localhost:8080/swagger-ui.html on browser to see API details
* Click on Execute button to execute below service
* Account List Enquiry - http://localhost:8080/v1/getAllAccountDetails
* Mention account number as 585309209 or 585309209 and execute
* below service to get account transaction history
* Account Transaction Enquiry - http://localhost:8080/v1/{accountNumber}
