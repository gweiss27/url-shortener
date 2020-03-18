# URL Shortening project

Your mission, should you choose to accept it, is to build a simple URL-shortener service (think bit.ly). 
You will find that the directions for the challenge are limited as we are looking to see what you value when coding. 
We expect you to spend around 4-5 hrs working on the challenge. You may, however, choose to spend more 
time to output better functionality.
 
## Requirements

### Functional Requirements
- Given a URL, the service should return a shortened version of it. 
- When a user requests the shortened URL, they should be redirected to the originally provided URL. 
- After 10 requests to a shortened URL, it should become invalid. 

### Web Interface
The service should have a simple web interface with the following features:
- A field to enter the actual URL 
- A button to generate shortened version of the URL 
- A way to display the state of the request (success/failure) 
 
### Technical Requirements
- Java as the coding language 
- Public facing Restful API
 
## Deliverables

- Github repo with code to be demo’d 
- Be able to speak to how the solution was designed, implemented, etc.
- Testing (TBD)
 
#### Stretch Goals
- Run in AWS 
- Gather analytics and expose via REST API / UI

## Prerequisites:
For test and run this project you just need to have `mvn` command in your path.

## Run all tests:
There are several integration and unit tests for project, you can run them by this command:

    mvn test

## Run project:
In order to run this project you need to run this command:

    mvn spring-boot:run
    
## How to shorten a URL:
In order to shortening a url you should use this rest api:

url: `localhost:8080/api/v1/url/shorten`

http method: `POST`

request body:

    {
        "originalUrl": "https://cabonlinegroup.com/en"
    }

success response body (http status `200`):  

    {
        "shortenUrl": "http://localhost:8080/tiny/3ae2n1"
    }
    
failure response body (http status `400`):

    {
        "errorMessage": "The URL entered is invalid"
    }