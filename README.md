### How to run?

```agsl
mvn package
./mvnw spring-boot:run
```

or run
```agsl
java -jar target/leboncoin-interview-0.0.1-SNAPSHOT.jar
```

Tomcat server start on port 8080.

Example :
```
curl 'http://localhost:8080/fizzBuzz?limit=10&divide1=2&divide2=3&replace1=fizz&replace2=buzz'
```

### With Docker

```agsl
docker build --tag=leboncoin-interview:latest .
docker run -p8887:8080 leboncoin-interview:latest
```

```
curl 'http://localhost:8887/fizzBuzz?limit=10&divide1=2&divide2=3&replace1=fizz&replace2=buzz'
```