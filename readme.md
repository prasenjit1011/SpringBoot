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

---

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

---

## Importand Cmd Build Project

Clean and build the application:

```bash
mvn clean install
```

---

## Run Application

Start the Spring Boot application:

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---

## Project Structure

```text
Folder PATH listing
C:.
├───.github
│   └───workflows
├───api
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───example
│   │   │           └───demo
│   │   │               ├───config
│   │   │               ├───controller
│   │   │               ├───entity
│   │   │               ├───repository
│   │   │               └───service
│   │   └───resources
│   │       ├───db
│   │       │   └───migration
│   │       ├───static
│   │       └───templates
│   └───test
│       └───java
│           └───com
│               └───example
│                   └───demo
├───terraform
└───uploads

```

---

## Cloud Deployment

This application can be deployed on:

* Google Cloud Platform (GCP)
* AWS
* Azure
* Docker Containers

---

## Useful Command

Export all source code into a single text file:

```cmd
for /f "delims=" %f in ('dir /s /b ^| findstr /v /i "\\.mvn\\ \\api\\ \\target\\ \\public\\ \\uploads\\ \\.git\\ \\.gitignore README.md mvnw mvnw.cmd .env"') do @echo Processing: %f & (echo ===== %f ===== & type "%f" & echo.)>>"../all_code.txt"
```

---

## Technologies Used

* Java 21
* Spring Boot 3.5.x
* Spring Web
* Spring Data JPA
* Spring Security
* JWT Authentication
* PostgreSQL
* Maven
* Lombok
* Thymeleaf (Optional)

---

## Author

**Prasenjit**

GitHub: https://github.com/<your-github-username>
