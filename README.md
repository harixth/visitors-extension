# Visitors Extension Service

## Description

This project has been bootstrapped with [Spring Boot](https://github.com/spring-projects/spring-boot) framework. It responsible for record visitor's visits in the database and manage them  

## Configuration

Make sure the config is pointing to the right database

## Running the app

Project will be running at http://localhost:8080.

```bash
# package project as jar
$ mvn clean package

# execute the jar
$ java -jar jmbi-visitors-extension:1.0.0
```

using docker

```bash
# build the container
$ docker build -t jmbi-visitors-extension:1.0.0 .

# run the container
$ docker run -d -p 8080:8080 jmbi-visitors-extension:1.0.0
```

## Support

Please reach out to [Harith](https://github.com/harixth) if you faced any issue with this project.
