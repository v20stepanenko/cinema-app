package cinema.project.dao.impl;

import cinema.project.dao.AbstractDao;
import cinema.project.dao.MovieDao;
import cinema.project.model.Movie;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory factory) {
        super(factory, Movie.class);
    }
}
