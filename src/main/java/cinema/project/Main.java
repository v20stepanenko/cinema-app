package cinema.project;

import cinema.project.exception.AuthenticationException;
import cinema.project.lib.Injector;
import cinema.project.model.CinemaHall;
import cinema.project.model.Movie;
import cinema.project.model.MovieSession;
import cinema.project.model.Order;
import cinema.project.model.ShoppingCart;
import cinema.project.model.User;
import cinema.project.security.AuthenticationService;
import cinema.project.service.CinemaHallService;
import cinema.project.service.MovieService;
import cinema.project.service.MovieSessionService;
import cinema.project.service.OrderService;
import cinema.project.service.ShoppingCartService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("cinema.project");
        MovieService movieService =
                (MovieService) injector.getInstance(MovieService.class);

        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);
        System.out.println(movieService.get(fastAndFurious.getId()));
        movieService.getAll().forEach(System.out::println);
        CinemaHall firstCinemaHall = new CinemaHall();
        firstCinemaHall.setCapacity(100);
        firstCinemaHall.setDescription("first hall with capacity 100");

        CinemaHall secondCinemaHall = new CinemaHall();
        secondCinemaHall.setCapacity(200);
        secondCinemaHall.setDescription("second hall with capacity 200");

        CinemaHallService cinemaHallService =
                (CinemaHallService) injector.getInstance(CinemaHallService.class);
        cinemaHallService.add(firstCinemaHall);
        cinemaHallService.add(secondCinemaHall);

        System.out.println(cinemaHallService.getAll());
        System.out.println(cinemaHallService.get(firstCinemaHall.getId()));
        MovieSession tomorrowMovieSession = new MovieSession();
        tomorrowMovieSession.setCinemaHall(firstCinemaHall);
        tomorrowMovieSession.setMovie(fastAndFurious);
        tomorrowMovieSession.setShowTime(LocalDateTime.now().plusDays(1L));

        MovieSession yesterdayMovieSession = new MovieSession();
        yesterdayMovieSession.setCinemaHall(firstCinemaHall);
        yesterdayMovieSession.setMovie(fastAndFurious);
        yesterdayMovieSession.setShowTime(LocalDateTime.now().minusDays(1L));

        MovieSessionService movieSessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);
        movieSessionService.add(tomorrowMovieSession);
        movieSessionService.add(yesterdayMovieSession);

        System.out.println(movieSessionService.get(yesterdayMovieSession.getId()));
        System.out.println(movieSessionService.findAvailableSessions(
                fastAndFurious.getId(), LocalDate.now()));

        AuthenticationService authenticationService =
                (AuthenticationService) injector.getInstance(AuthenticationService.class);

        authenticationService.register("user1", "pass1");
        authenticationService.register("user2", "pass2");
        User user1 = null;
        try {
            user1 = authenticationService.login("user1", "pass1");
        } catch (AuthenticationException exception) {
            System.out.println(exception);
        }
        ShoppingCartService shoppingCartService =
                (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        OrderService orderService =
                (OrderService) injector.getInstance(OrderService.class);
        ShoppingCart user1ShoppingCart = shoppingCartService.getByUser(user1);
        shoppingCartService.addSession(tomorrowMovieSession, user1ShoppingCart.getUser());
        orderService.completeOrder(shoppingCartService.getByUser(user1));
        List<Order> ordersHistory = orderService.getOrdersHistory(user1);
        System.out.println("*****************");
        System.out.println(ordersHistory);
    }
}
