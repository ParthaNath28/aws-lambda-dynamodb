### Sample java project using AWS lambda functionalities while connecting to AWS dynamo db

The AWS lamba service provides a convenient way of hosting business logics in a server less manner. This project holds the source code of
sample java maven project which can be uploaded in the AWS lambda service as a shaded jar file.


### Dependencies
There are several prerequisite dependencies you should install on your machine prior to starting to work with this project:

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

* An IDE to write your tests on - [Eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/marsr) or [IntelliJ](https://www.jetbrains.com/idea/download/#)

* [Maven](https://maven.apache.org/)

* AWS account where a lamba function needs to created with the package name of the Application class along with the handler method

* AWS API gateway cretaed for the lambda function to be accessible as a REST API. Please visit AWS documenations or tuorials to see how an API gateway needs to be created and can be configured to make use of the lamba function

    Handler - com.example.aws.lambda.Application::handleRequest

# Getting Started

* Set up the AWS lambda and the dynamo db dependencies in the pom file


## Running sample as is


* The clean package shade:shade command would create the shaded jar file

* Upload the jar file in the lamba console.

* Hit the API gateway which is configured to handle sample GET / POST request to get the data from dynamo DB and create a new record.

* Please make sure the lambda function has proper IAM policy to access the dynamo db database.

https://aws.amazon.com/blogs/security/how-to-create-an-aws-iam-policy-to-grant-aws-lambda-access-to-an-amazon-dynamodb-table/

GET /dev/student/1 HTTP/1.1
Host: eolgkjkrk3.execute-api.us-east-2.amazonaws.com
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 048abacd-326d-d774-b8af-56370fbadbfe

{
    "id": 1,
    "name": "Nath"
}


POST /dev/student HTTP/1.1
Host: eolgkjkrk3.execute-api.us-east-2.amazonaws.com
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: a5d1ea47-e6d3-51a6-14c1-fdd929b46a97


   {"id":1,
   "name":"Nath"
   }