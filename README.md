# Securing REST APIs (Authentication & Authorization - Role Based)

Secure Person API which has two users:
1. user
2. admin

Following roles are available:
1. USER
2. ADMIN

The user and roles are setup in PersonSecurityConfigurer as shown below:

**_NOTE:_** User & Roles can be setup by gettting the information from DB

```java
 auth.inMemoryAuthentication()
     .withUser("user")
        .password("{noop}password")
        .roles("USER")
     .and()
        .withUser("admin")
            .password("{noop}password")
            .roles("USER", "ADMIN");
```
API/REST roles based access has been setup as shown below:


```java
  http
     //HTTP Basic authentication
     .httpBasic()
     .and()
     .authorizeRequests()
         .antMatchers(HttpMethod.GET, "/persons/**").hasRole("USER")
         .antMatchers(HttpMethod.POST, "/persons").hasRole("ADMIN")
         .antMatchers(HttpMethod.PUT, "/persons/**").hasRole("ADMIN")
         .antMatchers(HttpMethod.PATCH, "/persons/**").hasRole("ADMIN")
         .antMatchers(HttpMethod.DELETE, "/persons/**").hasRole("ADMIN")
     .and()
        .csrf()
        .disable()
        .formLogin()
        .disable();
```

## Run application

```bash
mvn spring-boot:run

```

## Demo


### GET persons with NO credentials

_**Request**_
```bash
curl localhost:8080/persons

```
_**Output**_
```json
{
  "timestamp":"2020-01-09T20:31:03.100+0000",
  "status":401,
  "error":"Unauthorized",
  "message":"Unauthorized",
  "path":"/persons",
 }
```

### POST a new person with NO credential - create a new Person

_**Request**_
```bash
curl -X POST localhost:8080/persons -H "Content-type:application/json" 
-d {\"firstName\":\"ABC\",\"lastName\":\"DEF\",\"phoneNumber\":\"123\"}

```
_**Output**_
```json
{ 
  "timestamp":"2020-01-09T20:38:03.492+0000",
  "status":401,
  "error":"Unauthorized",
  "message":"Unauthorized",
  "path":"/persons",
 }
```

### GET persons with credentials

_**Request**_
```bash
curl localhost:8080/persons -u user:password

```
_**Outputt**_
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

