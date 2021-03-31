# Real estate registry #

This mini program creates three entities in which we store data about our buildings and owners

### What I am using? ###

* Spring Boot
* H2 database
* Mockito
* JUnit 5
* Lombok

### How to use it? ###

Start the program in IDE

#### Then you can access all functionality through URL
 * http://localhost:8080/

#### You can access three entities:
 * Owner
 * Building
 * Property

All URL commands starts with entity first, for example:  
`http://localhost:8080/owner/all` -- will return all owners

#### HTTP commands through Postman:
* **Owner**:
    * `GET http://localhost:8080/owner/{id}`
    * `GET http://localhost:8080/owner/all`
    * `POST http://localhost:8080/owner`
    * `PUT http://localhost:8080/owner`
    * `DELETE http://localhost:8080/owner/{id}`  
    **To get total tax of particular owner**
    * `GET http://localhost:8080/owner/tax/{id}`
* **Building**:
  * `GET http://localhost:8080/building/{id}`
  * `GET http://localhost:8080/building/all`
  * `POST http://localhost:8080/building/{ownerId}/{propertyID}`
  * `PUT http://localhost:8080/building/{ownerId}/{propertyID}`
  * `DELETE http://localhost:8080/building/{id}`

* **Property**:
    * `GET http://localhost:8080/property/{id}`
    * `GET http://localhost:8080/property/all`
    * `POST http://localhost:8080/property`  
    * `PUT http://localhost:8080/property`
    * `DELETE http://localhost:8080/property/{id}`  
    
**These commands are working on any browser**  
**BUT** `POST` and `PUT` methods need particular data inputs,
so you can enter them using Postman.


