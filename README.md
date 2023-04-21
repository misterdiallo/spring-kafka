# Spring kafka Basic


1. Need to have docker installed and run
 

2. create spring project with those dependencies: 
- `spring-kafka` for using kafka
- `lombok` to reduce writing many code (getters, setters,..)
- `jackson-databind` to do the object mapping with the data to json
- `jackson-datatype-jsr310` to be able to map the LocalDateTime to json 


3. Add docker configurations in `docker-compose.yml`


4. Write some configuration in the application.properties
- `misterdiallo.kafka.topic=customer.visit`: topic name 
- `spring.kafka.bootstrap-servers=localhost:9092`: kafka running port
- `spring.kafka.consumer.group-id=events` group id name of the kafka consumer 


5. Write the Kafka Config code `KafkaConfig.java` 


6. Write the Json Config code with the Object Mapper `JsonConfig.java` 


7. Write the pojo class for consuming data `CustomerVisitEvent`


8. Add the Consuming and Listining code `SpringKafkaApplication` 


9. Run the code `./mvnw spring-boot:run`





## Docker kafka running commands 

### Create a Topic
```
docker exec broker \
kafka-topics --bootstrap-server broker:9092 \
             --create \
             --topic "customer.visit"
```

### Command Line Consumer
```
docker exec --interactive --tty broker \
kafka-console-consumer --bootstrap-server broker:9092 \
                       --topic "customer.visit" \
                       --from-beginning
```

### Command Line Producer
```
docker exec --interactive --tty broker \
   kafka-console-producer --bootstrap-server broker:9092 \
                          --topic "customer.visit"
```



### Full Documentation of docker running commands
[https://developer.confluent.io/quickstart/kafka-docker/](https://developer.confluent.io/quickstart/kafka-docker/)

