### Simple project for representing containerized services with Docker and Docker Compose.

* schema.sql - SQL script with simple random data.
* reviews.csv - data with reviews for presenting 'mount' functionality.

run project:

```shell
docker compose up
```

Test endpoints after run:

/films - get data from film-service and review-service.

```http request
http://localhost:8080/films
```

Study course: https://www.udemy.com/course/docker-kubernetes-the-practical-guide/
