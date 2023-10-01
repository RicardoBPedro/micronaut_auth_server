# Micronaut JWT Authenticantion Server
This server is build under Micronaut + JWT + PostgreSQL + Jooq + Flyway + Lombok in order to create and manage users login.
Jooq is used to generate some class files at build time based on the migration file resources/db/postgres/V1__create_user_table.sql

### Requirements
* [JAVA 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Git](https://git-scm.com/)
* [Docker](https://www.docker.com/products/docker-desktop/)
## Getting started

:warning: Before start, make sure your Docker environment is up and running.
In order to build the project run the command below.
```
./gradlew build
```
It will generate the missing files and setup the Postgresql docker container.

In order to remove the docker container and its database, run:
```
docker rm -f -v <container_name>
```
Use the string connection below, with user mmorpg_auth and password 123, in order to connect to the PostgreSQL docker containe:
```
jdbc:postgresql://127.0.0.1:5432/mmorpg_auth
```
In order to change these database configs, is must update the build.gradle, docker-compose.yml and application.ymml
## Authentication

In order to register you can make a POST API request to {{api_url}}/register with body of
```
{
    "username": "username",
    "email": "email@test.com",
    "password": "password"
}
```
where the {{api_url}} can be set to localhost:8080. The port can be configured in application.yml configuration file.

This functionality is configured in UnsecuredAccountController

In order to sign in, make a POST request to {{api_url}}/login with body of:
```
{
    "username": "username",
    "password": "password"
}
```
This functionality comes directly from Micronaut, it can be configured in application.yml

## Micronaut 4.1.2 Documentation

- [User Guide](https://docs.micronaut.io/4.1.2/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.1.2/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.1.2/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

- [Micronaut Gradle Plugin documentation](https://micronaut-projects.github.io/micronaut-gradle-plugin/latest/)
- [GraalVM Gradle Plugin documentation](https://graalvm.github.io/native-build-tools/latest/gradle-plugin.html)
- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


