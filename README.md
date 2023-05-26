## fizz-buzz REST server

The original fizz-buzz consists in writing all numbers from 1 to 100, and just replacing all multiples of 3 by "fizz", all multiples of 5 by "buzz", and all multiples of 15 by "fizzbuzz".

The output would look like this: "1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16,...".


### Prerequisites
- maven 3.9.1
- java 17
- docker (optional)


### How to run?

Build with 

```agsl
mvn package
```

Run with
```agsl
./mvnw spring-boot:run
```
or 
```agsl
java -jar target/leboncoin-interview-0.0.1-SNAPSHOT.jar
```

Tomcat server start on port 8080.

Example :
```
curl 'http://localhost:8080/fizzBuzz?limit=10&divide1=2&divide2=3&replace1=fizz&replace2=buzz'
curl 'http://localhost:8080/requests/max'
```

#### With Docker

```agsl
docker build --tag=leboncoin-interview:latest .
docker run -p8887:8080 leboncoin-interview:latest
```

```
curl 'http://localhost:8887/fizzBuzz?limit=10&divide1=2&divide2=3&replace1=fizz&replace2=buzz'
curl 'http://localhost:8887/requests/max'
```


### Endpoint documentation
Check api documentation at :
`http://localhost:8080/swagger-ui/index.html`