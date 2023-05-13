# demo-tsid-hibernate
Demo project to test TSID (Time-Sorted Identifiers) instead of UUID/ sequence ID as primary keys in the DB




##Start a DB with

Docker’s MySQL images has user root@% by Oracle only has root@localhost.

Use Docker’s version called mysql:8.0

    docker run --name=mysql-demo --restart on-failure --detach   -e MYSQL_ROOT_PASSWORD=my-password -e MYSQL_DATABASE=app-db  -e MYSQL_USER=app-db-user -e MYSQL_PASSWORD=my-password --publish 3306:3306 mysql:8.0


The DB client must set "allowPublicKeyRetrieval=true"

    docker stop/start/rm mysql-demo

    docker exec -it mysql-demo mysql -uroot -p


## Testing the REST API
In this very small sample app there one endpoint to list, retrieve and create books.

To create a book:

```
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"description":"The Silmarillion"}' \
  http://localhost:8080/api/v1/books

```

To list all books:

```
curl http://localhost:8080/api/v1/books
```
