## Important Cmd 
java -version
echo %JAVA_HOME%
mvn -version

mvn clean install
mvn spring-boot:run

# Collect DB Credentials From (GitHub Login / prasenjit.aluni@gmail.com): 
### https://console.neon.tech/app/projects/bold-lab-35054172?database=nestcrud
DATABASE_URL=jdbc:postgresql://ep-withered-frost-a5etb539-pooler.us-east-2.aws.neon.tech/nestcrud?sslmode=require
DATABASE_USERNAME=neondb_owner
DATABASE_PASSWORD=

# Download Basic Project Setup From

https://start.spring.io/?utm_source=chatgpt.com 

## Select 
### Project : Maven
### Language: Java
### Spring Boot: 3.5.15 ( Not more than 3.5.x)
### Project Metadata
#### Group : com.example
#### Artifact : demo
#### Package name : com.example.demo

### Packaging : Jar
### Configuration : YAML
### Java : 21

### Click on btn : GENERATE

GCP

for /f "delims=" %f in ('dir /s /b ^| findstr /v /i "\\.mvn\\ \\api\\ \\target\\ \\public\\  \\.git\\ \\.gitignore README.md mvnw mvnw.cmd"') do @echo Processing: %f & (echo ===== %f ===== & type "%f" & echo.)>>"../all_code.txt"