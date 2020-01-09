

### GET person vanila with NO credentials

```bash
curl localhost:8080/persons

```
```json
{"timestamp":"2020-01-09T20:31:03.100+0000","status":401,"error":"Unauthorized","message":"Unauthorized","path":"/persons"}
```

### POST a new person with NO credential

```bash
curl -X POST localhost:8080/persons -H "Content-type:application/json" 
-d {\"firstName\":\"ABC\",\"lastName\":\"DEF\",\"phoneNumber\":\"123\"}

```

```json
"timestamp":"2020-01-09T20:38:03.492+0000","status":401,"error":"Unauthorized","message":"Unauthorized","path":"/persons"}
```

### GET person vanila with  credentials

```bash
curl localhost:8080/persons -u user:password

```
```json
    [
      {
        "id":1,
        "firstName":"Gaurav",
        "lastName":"Malhotra",
        "phoneNumber":"123",
        },
        {
          "id":2,
          "firstName":"Shikha",
          "lastName":"Malhotra",
          "phoneNumber":"456",
          },
          {
            "id":3,
            "firstName":"Naman",
            "lastName":"Malhotra",
            "phoneNumber":"789",
          },
          {
            "id":4,
            "firstName":"Aarika",
            "lastName":"Malhotra",
            "phoneNumber":"111",
          }
    ]
```


# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/maven-plugin/)
* [Spring Security](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-security)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

