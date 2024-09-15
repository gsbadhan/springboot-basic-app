# springboot-basic-app
springboot basic app with JAVA

### JAVA 17
### Springboot 3.3.3
### Gradle
### Lombok
### REST Controller

#### Swagger UI http://localhost:8090/springbootapp/swagger-ui/index.html

#### Curl sample
curl  -X POST \
'http://localhost:8090/springbootapp/v1/students' \
--header 'Accept: */*' \
--header 'Content-Type: application/json' \
--data-raw '{
"id":1001,
"name":"xx",
"age":10
}'

