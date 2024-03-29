# Micronaut JWT Authenticantion Server
This server is build under Micronaut + JWT + PostgreSQL + Jooq + Flyway + Lombok in order to create and manage users login.

Jooq is used to generate some class files at `build time` based on the migration file `resources/db/postgres/V1__create_user_table.sql`

### Requirements
* [JAVA 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Git](https://git-scm.com/)
* [Docker](https://www.docker.com/products/docker-desktop/)
## Getting started


:warning: :warning: BEFORE START, MAKE SURE DOCKER ENVIROMENT IS UP AND RUNNING. :warning: :warning:


In order to build the project, run the command below.
```
./gradlew build
```

It will generate the missing files, setup and start the Postgresql docker container.

In order to remove the docker container and its database, run `docker rm -f -v <container_name>`.

Use the string connection ```jdbc:postgresql://127.0.0.1:5432/mmorpg_auth```, with user ```mmorpg_auth``` and password ```123``` in order to connect to the PostgreSQL docker containe.

In order to change this database configs, you must update the ***build.gradle***, ***docker-compose.yml*** and ***application.yml***.
## Authentication

In order to start the application, run the command below.
```
./gradlew run
```

In order to register you can make a ***POST*** request to ```localhost:8080/register``` with body of
```
{
    "username": "username",
    "email": "email@test.com",
    "password": "password"
}
```
This functionality is configured in ***UnsecuredAccountController***.

In order to sign in, make a ***POST*** request to `localhost:8080/login` with body of:
```
{
    "username": "username",
    "password": "password"
}
```
This functionality comes directly from Micronaut, it can be configured in ***application.yml***

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


