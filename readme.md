## Important Cmd 
java -version
echo %JAVA_HOME%
mvn -version
mvn spring-boot:run



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

for /f "delims=" %f in ('dir /s /b ^| findstr /v /i "\\target\\ \\.mvn\\ \\public\\ \\venv\\  \\__pycache__\\    \\.git\\ \\alembic\\  \\.next\\ \\.gitignore README.md CLAUDE.md AGENTS.md package-lock.json mvnw mvnw.cmd"') do @echo Processing: %f & (echo ===== %f ===== & type "%f" & echo.)>>"../all_code.txt"