# Restful API with Spring Boot, MondoDB

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/amac81/Java-sb-mongodb01/blob/main/LICENSE) 

# About the project

Java-sb-mongodb01 is a Project developed in the course Java COMPLETO 2023 Object Oriented Programming +Projects.

##  Its objectives:

- Understand the main differences between document-oriented and relational paradigm;
- Implement CRUD operations;
- Reflect on design decisions for a document-oriented database;
- Implement associations between objects:
  - Nested objects;
  - References;
- Perform queries with Spring Data and MongoRepository;

## Conceptual model
![Modelo Conceitual](https://github.com/amac81/Java-sb-mongodb01/blob/main/assets/raw/conceptual_model.png)

# Technologies used
## Back end
- Java
- Spring Boot
- MongoDB
- Maven

# Patterns used
- Layers pattern

# How to run the project

## Back end
Prerequisites: 
  - Java 17;
  - MongoDB database server;

```bash
# clone repository
git clone https://github.com/amac81/Java-sb-mongodb01.git

# run the project
./mvnw spring-boot:run (Linux, OSX, Solaris)

mvnw.cmd spring-boot:run (Windows)
```

# How to test the project

Prerequisites: 
  - Postman or Internet Browser;

### Endpoint for users

```bash

Examples:

# GET users
http://localhost:8080/users

# GET user by Id
http://localhost:8080/users/64c6814528bec95b5b18d0f2

# GET posts from user Id
http://localhost:8080/users/64c6814528bec95b5b18d0f2/posts

# POST user
http://localhost:8080/users
body:
{
    "name": "Billy Saint",
    "email": "billy@mail.com"    
}

# DELETE user (by Id)
http://localhost:8080/64c6814528bec95b5b18d0f2

# PUT user (update user by Id info)
http://localhost:8080/users
body:
{
    "name": "new name",
    "email": "new email"    
}

```

### Endpoint for posts

```bash

Examples:

# GET post by Id
http://localhost:8080/posts/64c6814528bec95b5b18d0f9

# GET posts containing certain text in the title
http://localhost:8080/posts/titlesearch?text=the%20Future

# GET posts and comments containing certain text in the title or body and between dates
http://localhost:8080/posts/fullsearch?text=body&minDate=2023-07-23T00:00:00.000Z&maxDate=2023-07-25T23:59:00.000Z

```

# Author

Arnaldo Manuel de Almeida Canelas

https://www.linkedin.com/in/arnaldocanelas
