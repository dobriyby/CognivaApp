# Cognive-microservices

run `gradle wrapper` once

 then `gradle [task]` . Useful tasks:

* `clean` - to clean
* `build` - to rebuild project
* `bootRun` - to build and run SpringBoot project.
            Notice that build stops at ~ 70-80%, but project is running

Endpoints:

GET:

  - `localhost:8080/` - echo
  - `localhost:8080/userlists` - get all existing lists
  - `localhost:8080/userlists/{number}` - get specific list info


POST:

  - `localhost:8080/create` - create list with default name


TODO:

* Userlists service:

  1. Pass "name" parameter to POST "/userlists/create"
  2. inject UserlistService into ListController based on app args
  3. implement methods in UserlistServiceDatabase

    + store in local db
    + store in remote db
