# RabbitMQ Demo 

## Implementation

The project has two services 
- producer-svc
- consumer-svc

These services are implemented using `Spring Boot` and `amqp` starter.

The project is organized as a maven project and in order to compile, test and create a package maven is used.

Building the application

You could use maven to test and build the jar file.

In the root directory of the project run the following commands

```bash

# Compile
mvn -B clean compile

#Test
mvn -B clean test


#Create the package
mvn -B clean package

```
## Run

```bash

#create network between docker instances
docker network create --subnet=192.168.42.0/24 docknet

#run with docker compose
# 1. rabbitmq-server
# 2. mq-consumer
# 3. mq-producer
docker-compose up
```

## Test the endpoint 

POST request (You can check [postman-collection](rabbitmq-demo.postman_collection.json))
- URL: `http://localhost:8080/messages`
- Body

```json
{
	"id": "dlM3qwe9",
	"name": "Jane",
	"surname": "Winter"
}
```

