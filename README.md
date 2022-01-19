# Cinema App Pet Project
#### Describe
The application allows you to add movies, add new movie sessions and add cinema hall as admin. Register new customers, authorization and buy tickets. 

### List of endpoints:
##### Without authentication:
```POST: /login``` — login page
```POST: /register``` — registration page

##### For users and admins:
```GET: /cinema-halls``` — show all the cinema halls
```GET: /movies``` — show all movies
```GET: /movie-sessions/available``` — show all available movie sessions
```GET: /orders``` — show all orders by logged user
```POST: /orders/complete``` — complete current order
```PUT: /shopping-carts/movie-sessions``` — add movie session to shopping cart
```GET: /shopping-carts/by-user``` — show shopping cart contents of logged user 

##### For admins:
```GET: /users/by-email``` — find user by email
```POST: /cinema-halls```— add new cinema hall
```POST: /movies```— add new movie
```POST: /movie-sessions```— add new movie session
```PUT: /movie-sessions/{id}```— update movie session by id
```DELETE: /movie-sessions/{id}```— delete movie session by id

#### Technologies::
1. Spring (MVC, Security)
2. Hibernate
3. MySQL
4. Apache Tomcat
5. Maven

## Setup recommendations
1. Configure Apache Tomcat.
2. Create new schema in MySQL.
3. Insert `YOUR_DRIVER`, `YOUR_DATABASE_URL`, `YOUR_USERNAME`, `YOUR_PASSWORD` in `db.properties` file in `src/main/resources`.
4. Run this app with Tomcat local server.
5. You already have `ADMIN` user with username `admin@google.com` and password `password` , or register a new user.
