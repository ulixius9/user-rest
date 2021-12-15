# user-rest

This is a demo application build using Spring-Boot which perfroms CURD operation using REST API on User Profile.


### User Profile Table Structure

| Field Name | Data Type |
| ---------- | --------- |
| UserId     | Int       |
| Name       | String    |
| City       | String    |
| Age        | Int       |
| Email      | String    |
| Mobile     | Int       |


# REST API

The REST API of this app is described below.
 
## Get list of all users

### Request

`GET /api/users/`

    GET http://localhost:8089/api/users/

### Response

    HTTP/1.1 200 OK
    [
      {
          "userId": 1,
          "name": "Mayur",
          "city": "Mumbai",
          "age": 22,
          "email": "test@gmail.com",
          "mobile": 9876532101
      }
    ] 

## Get user by id

### Request

`GET /api/user/{id}`

    GET http://localhost:8089/api/user/1/

### Response

    HTTP/1.1 200 OK
    {
        "userId": 1,
        "name": "Mayur",
        "city": "Mumbai",
        "age": 22,
        "email": "test@gmail.com",
        "mobile": 9876532101
    }
    
## Create User Profile

### Request

`POST /api/user/`

    POST http://localhost:8089/api/user/
    Content-Type: application/json
    Request body:
      {
        "name":"Test",
        "city":"Banglore",
        "age":22,
        "email":"test@gmail.com",
        "mobile":123456
      }

### Response

    HTTP/1.1 201 Created
    {
      "userId": 2,
      "name": "Test",
      "city": "Banglore",
      "age": 22,
      "email": "test@gmail.com",
      "mobile": 123456
    }

## Update User Profile

### Request

`PUT /api/user/{id}`

    PUT http://localhost:8089/api/user/1
    Content-Type: application/json
    Request body:
      {
        "name":"Test",
        "city":"Banglore",
        "age":22,
        "email":"test1@gmail.com",
        "mobile":123456
      }

### Response

    HTTP/1.1 200 Ok
    {
      "userId": 2,
      "name": "Test",
      "city": "Banglore",
      "age": 22,
      "email": "test1@gmail.com",
      "mobile": 123456
    }


## Delete User Profile by Id

### Request

`DELETE /api/user/{id}`

    DELETE http://localhost:8089/api/user/1/

### Response

    HTTP/1.1 204 No Content


## Delete All User Profiles 

### Request

`DELETE /api/users`

    DELETE http://localhost:8089/api/users

### Response

    HTTP/1.1 204 No Content
    
