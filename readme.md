# Spring Boot Demo Project

A basic Spring Boot REST API project built with **Java 21**, **Spring Boot 3.5.x**, **Maven**, and **PostgreSQL (Neon DB)**.

---

## Prerequisites

Ensure the following software is installed:

* Java 21
* Apache Maven 3.9+
* Git

Verify installation:

```bash
java -version
echo %JAVA_HOME%
mvn -version
```

mvn clean install
mvn clean spring-boot:run

## Project Setup

Generate the initial project from Spring Initializr:

https://start.spring.io/

### Configuration

| Option        | Value                                          |
| ------------- | ---------------------------------------------- |
| Project       | Maven                                          |
| Language      | Java                                           |
| Spring Boot   | 3.5.15 (Do not use versions higher than 3.5.x) |
| Group         | com.example                                    |
| Artifact      | demo                                           |
| Package Name  | com.example.demo                               |
| Packaging     | Jar                                            |
| Configuration | YAML                                           |
| Java Version  | 21                                             |

Click **Generate** and download the project.

---

## Database Configuration

Collect database credentials from:

GitHub Login: `prasenjit.aluni@gmail.com`

Neon Console:

https://console.neon.tech/app/projects/bold-lab-35054172?database=nestcrud

### Database Properties

```properties
DATABASE_URL=jdbc:postgresql://ep-withered-frost-a5etb539-pooler.us-east-2.aws.neon.tech/nestcrud?sslmode=require
DATABASE_USERNAME=neondb_owner
DATABASE_PASSWORD=<YOUR_PASSWORD>
```

Add these values to:

```yaml
src/main/resources/application.yml
```

Example:

```yaml
spring:
  datasource:
    url: ${DATABASE_URL}
    username: ${DATABASE_USERNAME}
    password: ${DATABASE_PASSWORD}

  jpa:
    hibernate:
      ddl-auto: update

    show-sql: true

    properties:
      hibernate:
        format_sql: true
```

### for /f "delims=" %f in ('dir /s /b AuthController.java AuthService.java LoginRequest.java LoginResponse.java pom.xml') do @echo ===== %f ===== >> "../all_code.txt" & type "%f" >> "../all_code.txt" & echo. >> "../all_code.txt"

### treee -I ".mvn|target|uploads|"


